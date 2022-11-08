package Get_Request;

import Base_Url.JsonplaceholderBaseUrl;
import Pojos.JsonPlaceHolderPojo;
import Utils.ObjectMapperUtils;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get21_ObjectMapper_Pojo extends JsonplaceholderBaseUrl {

    /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

    // ObjectMapper + Pojo = En İyi Yöntem
    @Test
    public void get14Pojo() {

        // Set the Url
        spec.pathParams("first", "todos", "second", 198);

        // Set the Expected Data
        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(10, "quis eius est sint explicabo", true);
        System.out.println("expectedData = " + expectedData);

        // Sen the Request and Get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        JsonPlaceHolderPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedData.getUserId(), actualData.getUserId());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getCompleted(), actualData.getCompleted());

    }

}
