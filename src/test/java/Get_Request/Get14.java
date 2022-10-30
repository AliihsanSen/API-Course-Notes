package Get_Request;

import Base_Url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get14 extends JsonplaceholderBaseUrl {

    // De-Serialization: Json datayı Java objesine çevirme
    // Serialization: Java objesini Json formatına çevirme.
    // De-Serialization: Iki türlü yapacağız.
    // Gson: Google tarafından üretilmiştir.
    // Object Mapper: Daha popüler...

      /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

    @Test
    public void get14() {

        // Set the URL
        spec.pathParams("first", "todos", "second", 2);

        // 2. Set The Expected Data (Put, Post and Patch)

        // 3. Send The Request And Get The Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

    }
}
