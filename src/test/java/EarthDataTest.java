import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;
import java.io.IOException;
import static io.restassured.RestAssured.given;


public class EarthDataTest {
    private static String baseUrl = ConfigReader.getProperty("hostUrl");
    private static String getEarthData = ConfigReader.getProperty("earthdata");


    @Test(description = "Verify the matchers in the response body ")
    public void validate_response()  {
         given().
                baseUri(baseUrl).
                when().
                get(getEarthData).then().
                log().all(). // to print the entire response in console
                assertThat().statusCode(200). // to verify the status code
                extract().path("count").equals("3542"); // To verify count key & value index  in response





}


}
