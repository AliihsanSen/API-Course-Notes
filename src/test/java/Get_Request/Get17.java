package Get_Request;


import Base_Url.GoRestBaseUrl;
import Test_Data.GoRestTestData;
import io.restassured.response.Response;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get17 extends GoRestBaseUrl {

     /*
        Given
            https://gorest.co.in/public/v1/users/2986
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
            /*
            {
        "meta": null,
        "data": {
            "id": 2986,
            "name": "Prof. Bala Pilla",
            "email": "pilla_prof_bala@zemlak.io",
            "gender": "female",
            "status": "active"
              }
         }
     */

    @Test
    public void get10() {

        // Set the URL
        spec.pathParams("first", "users", "second", 2986);

        // 2. Set The Expected Data (Put, Post and Patch)
        GoRestTestData obj = new GoRestTestData();
        Map<String, String> dataKeyMap = obj.dataKeyMapMet("Prof. Bala Pilla", "pilla_prof_bala@zemlak.io", "female", "active");
        Map<String, Object> expectedData = obj.expectedDataMethod(null, dataKeyMap);
        System.out.println(expectedData);

        // 3. Send The Request And Get The Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // 4. Do Assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.get("meta"), actualData.get("meta"));
        assertEquals(dataKeyMap.get("name"), ((Map) actualData.get("data")).get("name"));
        assertEquals(dataKeyMap.get("email"), ((Map) actualData.get("data")).get("email"));
        assertEquals(dataKeyMap.get("gender"), ((Map) actualData.get("data")).get("gender"));
        assertEquals(dataKeyMap.get("status"), ((Map) actualData.get("data")).get("status"));
        assertEquals(200, response.statusCode());

    }
}
