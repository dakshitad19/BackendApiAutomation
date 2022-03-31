import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.ExcelUtils;
import static io.restassured.RestAssured.given;


public class EmpResponseMsgTest {
    private static String baseUrl = ConfigReader.getProperty("hostUrl");
    private static String getEmpApi =  ConfigReader.getProperty("specificEmployeeApi");


  @Test(description = "Verify the specific msg in the response body successfully")
    public void validate_msg() {
      String empId = ExcelUtils.getCellData(0,0); // record using excel
      getEmpApi = getEmpApi+empId;
        String message =  given().
                baseUri(baseUrl).
                when().
                get(getEmpApi).
                then().extract().path("message");
        Assert.assertTrue(message.equals("Successfully! Record has been fetched.")); // verify msg assertion
        System.out.println(message);
        //assertThat().
        //statusCode(200).


    }

}
