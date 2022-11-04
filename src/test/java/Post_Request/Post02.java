package Post_Request;

import Base_Url.RestfulBaseUrl;
import Test_Data.RestfulTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Post02 extends RestfulBaseUrl {

    /*
   Given
       1) https://restful-booker.herokuapp.com/booking
       2) {
            "firstname": "John",
            "lastname": "Doe",
            "totalprice": 11111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2021-09-09",
                "checkout": "2021-09-21"
             }
          }
   When
       I send POST Request to the Url
   Then
       Status code is 200
       And response body should be like {
                                           "bookingid": 5315,
                                           "booking": {
                                               "firstname": "John",
                                               "lastname": "Doe",
                                               "totalprice": 11111,
                                               "depositpaid": true,
                                               "bookingdates": {
                                                   "checkin": "2021-09-09",
                                                   "checkout": "2021-09-21"
                                               }
                                           }
                                        }
    */

    @Test
    public void post02() {

        // 1. Set The URL
        spec.pathParam("first", "booking");

        // 2. Set The Expected Data ( put, post, patch)
        RestfulTestData obj = new RestfulTestData();
        Map<String, String> bookingDatesTestMap = obj.bookingDatesMethod("2021-09-09", "2021-09-21");
        Map<String, Object> expectedData = obj.expectedDataMethod("John", "Doe", 11111, true, bookingDatesTestMap);

        // 3. Send The Request And Get The Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).post("/{first}");
        response.prettyPrint();

        // 4. Do Assertion
    }
}
