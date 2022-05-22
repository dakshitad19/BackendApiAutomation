
    import io.qameta.allure.Issue;
    import io.qameta.allure.TmsLink;
    import org.testng.annotations.Test;
    import utils.ConfigReader;
    import java.io.IOException;
    import java.util.HashMap;

    import static io.restassured.RestAssured.given;


            public class CommentsApi {
            private static String baseUrl = ConfigReader.getProperty("hostUrl"); // reusable methods
                private static java.lang.String comurl = ConfigReader.getProperty("comments");

            //First Assertion Test

                @TmsLink("12345")
                @Issue("1909")
            @Test(description = "To Verify the status code 200 of Users API ")
            public void validate_get_status_code() throws IOException {
                given().
                        baseUri(baseUrl).
                        when().
                        get(comurl).
                        then().
                        log().all(). //to output the entire response in the console
                        assertThat().statusCode(200); // to check the status code is OK

            }

            //Second Assertion Test
            @Test(description = "To verify the Comments in each post in the expected Response") // Descriptions are used to give a display name for test in ALLURE Dashboard

            public void verifyResponse() {
                     given().
                      baseUri(baseUrl).
                        when().
                        get(comurl).then().log().body();
                      //then().extract().path("signature.version");
              //Assert.assertTrue(version.equals("1.4")); // check version assertion
                //System.out.println(version);


                }

                @Test(description = "")
                public void validateEmails(){
                    HashMap<java.lang.String, java.lang.String> map = new HashMap<>();
                    map.put("postId","21");
                    map.put("postId","22");
                    map.put("postId","23");
                    map.put("postId","24");
                    map.put("postId","25");
                    map.put("postId","26");
                    map.put("postId","27");
                    map.put("postId","28");
                    map.put("postId","29");
                    map.put("postId","30");
                 given().queryParam(String.valueOf(map)).
                            baseUri(baseUrl).
                            when().
                            get(comurl).then().log().body();
//hi



                }


        }






