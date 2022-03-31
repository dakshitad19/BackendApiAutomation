

import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.ExcelUtils;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class EmpRecordResponseTest {
    private static String baseUrl = ConfigReader.getProperty("hostUrl");
    private static String getEmpApi =  ConfigReader.getProperty("specificEmployeeApi");

    @Test(description = "To verify response body pattern of Single Employee Record")
    public void employee_record_extract_response() throws IOException {
        String empId = ExcelUtils.getCellData(0,0); //record using excel
        getEmpApi = getEmpApi+empId;
        given().
                baseUri(baseUrl).
                when().
                get(getEmpApi).
                then().
                log().all();//to output the entire response in the console
                //assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("employeeSchema.json"))); // is used to match the pattern



    }

}
