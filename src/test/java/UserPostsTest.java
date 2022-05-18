import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;
import java.io.IOException;
import static io.restassured.RestAssured.given;


public class UserPostsTest {
    private static String baseUrl = ConfigReader.getProperty("hostUrl");
    private static String getUserPost = ConfigReader.getProperty("userpost");

  //First Assertion
    @Test(description = "Verify the status Code of UserPost API ")
    public void verify_status_code()  {
         given().
                baseUri(baseUrl).
                when().
                get(getUserPost).then().
                log().all(). // to print the entire response in console
                assertThat().statusCode(200); // to verify the status code

}
    //Second Assertion
    @Test(description = "Verify the response as String ")
    public void validate_response()  {
        given().
                baseUri(baseUrl).
                when().
                get(getUserPost).then().log().all().
                extract().response().asString().contains("3");// to get response as string (posts written by the user)



    }

    //Third Assertion
    @Test(description = "Verify the one of the Title & Body from the  API ")
    public void check_post()  {
       String title =  given().
                baseUri(baseUrl).
                when().
                get(getUserPost).// to get response as string (posts written by the user)
                then().extract().path("[0].title");

        Assert.assertTrue(title.equals("asperiores ea ipsam voluptatibus modi minima quia sint")); // checking one of the title of posts
        System.out.println(title);

    } // how to print the body in console?


}
