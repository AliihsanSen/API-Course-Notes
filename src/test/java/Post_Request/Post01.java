package Post_Request;

import Base_Url.JsonplaceholderBaseUrl;
import Test_Data.JsonPlaceHolderTestData;
import org.junit.Test;

public class Post01 extends JsonplaceholderBaseUrl {

     /*
    Given
      1) https://jsonplaceholder.typicode.com/todos
      2) {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
                         }
   When
       I send POST Request to the Url
   Then
       Status code is 201
   And
       response body is like {
                               "userId": 55,
                               "title": "Tidy your room",
                               "completed": false,
                               "id": 201
                               }
     */

    @Test
    public void post01() {

        // 1. Set The URL
        spec.pathParam("first", "todos");

        // 2. Set The Expected Data ( put, post, patch)
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        obj.expectedDataMethod(55, "Tidy your room", false);


    }
}
