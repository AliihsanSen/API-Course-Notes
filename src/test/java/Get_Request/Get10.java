package Get_Request;

import Base_Url.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get10 extends ReqresBaseUrl {

    /*
   Given
       https://reqres.in/api/users/2
   When
       User send GET Request to the URL
   Then
       HTTP Status Code should be 200
   And
       Response format should be "application/json"
   And
       "email" is "janet.weaver@reqres.in",
   And
       "first_name" is "Janet"
   And
       "last_name" is "Weaver"
   And
       "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */

    @Test
    public void get10() {

        // Set the URL
        spec.pathParams("first", "api", "second", "users", "third", 2);

        // 2. Set The Expected Data (Put, Post and Patch)

        // 3. Send The Request And Get The Response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        // 4. Do Assertion
        // HTTP Status code should be 404
        // Status Line should be HTTP/1.1 404 Not Found



    }
}
