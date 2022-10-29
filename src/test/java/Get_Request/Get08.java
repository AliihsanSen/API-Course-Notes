package Get_Request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get08 {

    /*
   Given
       https://reqres.in/api/users/3
   When
       User sends a GET Request to the url
   Then
       HTTP Status Code should be 200
   And
       Content Type should be JSON
   And
       Status Line should be HTTP/1.1 200 OK
    */

    @Test
    public void get08() {

        // Set the URL
        String url = "https://reqres.in/api/users/3";

        // 2. Set The Expected Data (Put, Post and Patch)

        // 3. Send The Request And Get The Response
        Response response = given().when().get(url);
        response.prettyPrint();

        // 4. Do Assertion

        /* HTTP Status Code should be 200
           Content Type should be JSON
           Status Line should be HTTP/1.1 200 OK */
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");

    }
}
