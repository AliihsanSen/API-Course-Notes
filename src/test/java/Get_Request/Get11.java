package Get_Request;

import Base_Url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

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
        // HTTP Status code should be 200
        response.then().assertThat().statusCode(200);

        // Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"
        assertTrue(response.asString().contains("bookingid"));

    }
}
