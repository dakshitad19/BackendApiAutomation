
    import com.google.gson.JsonArray;
    import com.google.gson.JsonObject;
    import io.qameta.allure.Issue;
    import io.qameta.allure.Stories;
    import io.qameta.allure.TmsLink;
    import org.testng.Assert;
    import org.testng.annotations.Test;
    import utils.ConfigReader;
    import java.io.IOException;
    import static io.restassured.RestAssured.given;


            public class SbdbApproachDataApi {
            private static String baseUrl = ConfigReader.getProperty("hostUrl"); // reusable methods

            //First Assertion Test
               // @Stories("")
                //@Issue("")


                @TmsLink("12345")
                @Issue("1909")
            @Test(description = "To Verify the status code 200 of SBDB Close-Approach Data API ")
            public void validate_get_status_code() throws IOException {
                given().
                        baseUri(baseUrl).
                        //header("Content-type","'text/html; charset=UTF-8'.").
                        when().
                        get(baseUrl).
                        then().
                        log().all(). //to output the entire response in the console
                        assertThat().statusCode(200); // to check the status code is OK

            }

            //Second Assertion Test
            @Test(description = "To verify the Version in The Response Body Of API") // Descriptions are used to give a display name for test in ALLURE Dashboard

            public void validateVersion() {
              String version = given().
                      baseUri(baseUrl).
                        //header("Content-type","'text/html; charset=UTF-8'.").
                        when().
                        get(baseUrl).
                      then().extract().path("signature.version");
              Assert.assertTrue(version.equals("1.4")); // check version assertion
                System.out.println(version);


                }


        }






