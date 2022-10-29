package Get_Request;

import Base_Url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get11 extends RestfulBaseUrl {

  /*
    Given
        https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
    When
        User sends get request to the URL
    Then
        Status code is 200
    And
         Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"

    */

    @Test
    public void get11() {

        // Set the URL
        spec.pathParams("first", "booking").queryParams("firstname", "Almedin", "lastname", "Alikadic");

        // 2. Set The Expected Data (Put, Post and Patch)

        // 3. Send The Request And Get The Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        // 4. Do Assertion
        // HTTP Status code should be 404
        // Status Line should be HTTP/1.1 404 Not Found

    }
}
