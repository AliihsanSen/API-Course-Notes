package Put_Request;

import Base_Url.JsonplaceholderBaseUrl;
import Test_Data.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Put01 extends JsonplaceholderBaseUrl {

    /*
    Given
     1) https://jsonplaceholder.typicode.com/todos/198
     2) {
             "userId": 21,
             "title": "Wash the dishes",
             "completed": false
           }
    When
         I send PUT Request to the Url
    Then
         Status code is 200
    And
         response body is like   {
                   "userId": 21,
                   "title": "Wash the dishes",
                   "completed": false
                  }
    */

    @Test
    public void put01() {

        // 1. Set The URL
        spec.pathParams("first", "todos", "second", 198);

        // 2. Set The Expected Data ( put, post, patch)
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String, Object> expectedData = obj.expectedDataMethod(21, "Wash the dishes", false);

        // 3. Send The Request And Get The Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).put("/{first}/{second}");
        response.prettyPrint();

        // 4. Do Assertion


    }
}
