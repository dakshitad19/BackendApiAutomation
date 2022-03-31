package com.rest;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;
import java.io.IOException;
import static io.restassured.RestAssured.given;


public class AllEmployeeTest {
    private static String baseUrl = ConfigReader.getProperty("hostUrl"); // reusable methods
    private static String getEmpApi =  ConfigReader.getProperty("employeeApi");


//First Assertion Test
    @Test(description = "To Verify the status code 200 of ALL Employee API ")
    public void validate_get_status_code() throws IOException {
        given().
                baseUri(baseUrl).
                header("Content-type","'text/html; charset=UTF-8'.").
                when().
                get(getEmpApi).
                then().
                log().all(). //to output the entire response in the console
                assertThat().statusCode(200);

    }

    //Second Assertion Test
    @Test(description = "To verify profile_image is blank for each employee") // Descriptions used to give a display name for test in ALLURE Dashboard

        public void verifyImageIsEmptyForAllEmployee() {
            JsonObject response = new JsonObject();
            response = given().baseUri(baseUrl).
                    header("Content-type","'text/html; charset=UTF-8'.").
                    when().
                    get(getEmpApi).as(JsonObject.class);

            JsonArray empArray = response.get("data").getAsJsonArray();
            //Loop through the array and get each employee details.
            for (int i = 0; i < empArray.size(); i++) {
                JsonObject empObject = empArray.get(i).getAsJsonObject();
                Assert.assertEquals(empObject.get("profile_image").getAsString(), "");
          }

        }

    }

