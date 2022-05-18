
            import org.hamcrest.Matchers;
            import org.testng.Assert;
            import org.testng.annotations.Test;
            import utils.ConfigReader;
            import java.io.IOException;

            import static io.restassured.RestAssured.get;
            import static io.restassured.RestAssured.given;

            public class UsersAPITest {
                private static String baseUrl = ConfigReader.getProperty("hostUrl");
                private static String getUsersData =  ConfigReader.getProperty("users");


                //First Assertion
                @Test(description = "To Verify the status code 200 of Users API")
                public void verify_get_status_code() throws IOException {
                    given().
                            baseUri(baseUrl).
                            when().
                            get(getUsersData).
                            then().
                            log().all(). //to output the entire response in the console
                            assertThat().statusCode(200); //to check the result of status code





                }
                //Second Assertion
                @Test(description = "To Validate the username in the API")
                public void validate_username(){
                  given().
                    baseUri(baseUrl).
                    when().
                    get(getUsersData).
                      then().log().all().
                        assertThat().extract().path("username").equals("Samantha"); // to check the result of username Samantha





                }

                //Third Assertion
                @Test(description = "To Verify id in the API")
                public void verify_id(){
                    given().baseUri(baseUrl).queryParam("id",3).
                            when().
                            get(getUsersData).then().log().all(). // get operation
                            body("[0].id", Matchers.equalTo(3)). // verification of body
                    assertThat().extract().path("[0].id", String.valueOf(3));




                }

            }
