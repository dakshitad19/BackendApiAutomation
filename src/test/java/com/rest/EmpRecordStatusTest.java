package com.rest;

import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.ExcelUtils;
import java.io.IOException;
import static io.restassured.RestAssured.given;


public class EmpRecordStatusTest<JSONObject> {
    private static String baseUrl = ConfigReader.getProperty("hostUrl");
    private static String getEmpApi =  ConfigReader.getProperty("specificEmployeeApi");


    @Test(description = "Assertion to Fetch a single employee record using excel  & check status  200 ")
    public void single_employee_record_status_code() throws IOException {
        String empId = ExcelUtils.getCellData(0,0); // index is 0 giving data adding from xlsx sheet
        getEmpApi = getEmpApi+empId; // empid adding in URL
        given().
                baseUri(baseUrl).
                when().
                get(getEmpApi).
                then().
                log().all().//to output the entire response in the console
                assertThat().statusCode(200); //first assertion

    }





}









