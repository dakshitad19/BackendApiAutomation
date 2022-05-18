
            //import Statuscode.StatusCode;
            import org.testng.Assert;
            import org.testng.annotations.Test;
            import utils.ConfigReader;
            import java.io.IOException;

            import static io.restassured.RestAssured.get;
            import static io.restassured.RestAssured.given;

            public class AsteriodApiTest {
                private static String baseUrl = ConfigReader.getProperty("hostUrl");
                private static String getAsteroidData =  ConfigReader.getProperty("asteroiddata");

                @Test(description = "To Verify the status code 200 of SBDB Close-Approach Data  Asteriods API")
                public void validate_get_status_code() throws IOException {
                    given().
                            baseUri(baseUrl).
                            when().
                            get(getAsteroidData).
                            then().
                            log().all(). //to output the entire response in the console
                            assertThat().statusCode(200); //to check the result of status code





                }
                //Second Assertion
                @Test(description = "To Verify the QueryParams In The API")
                public void verify_query_params(){
                 given().
                    baseUri(baseUrl).queryParam("date-min","1900-01-01").
                    when().
                    get(getAsteroidData).
                      then().statusCode(200).log().body().
                        assertThat().extract().path("count").equals("5");  // to check the result of count key in response




                }

            }
