package Get_Request;

import Base_Url.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.*;
import static org.hamcrest.Matchers.emptyString;

public class Get09 extends ReqresBaseUrl {
       /*
   Given
       https://reqres.in/api/users/23
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Server is "cloudflare"
   And
       Response body should be empty

    */

    @Test
    public void get09() {

        // Set the URL
        spec.pathParams("first", "api", "second", "users", "third", 23);

        // 2. Set The Expected Data (Put, Post and Patch)

        // 3. Send The Request And Get The Response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        // 4. Do Assertion
        // HTTP Status code should be 404
        // Status Line should be HTTP/1.1 404 Not Found
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
        assertEquals(404, response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found", response.statusLine());

        // Server is "cloudflare"
        response.then().assertThat().header("Server", "cloudflare");
        assertEquals("cloudflare", response.header("Server"));

        // Response body should be empty
        assertEquals(0, response.asString().replaceAll("[^A-Za-z0-9]", "").length());


    }
}
