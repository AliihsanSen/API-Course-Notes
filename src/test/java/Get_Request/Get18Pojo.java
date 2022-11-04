package Get_Request;

import Base_Url.RestfulBaseUrl;
import org.junit.Test;

public class Get18Pojo extends RestfulBaseUrl {

     /*
     Given
         https://restful-booker.herokuapp.com/booking/18
     When
         I send GET Request to the URL
     Then
        Status code is 200
     And
        Response body is like:
                        {
                            "firstname": "Dane",
                            "lastname": "Combs",
                            "totalprice": 111,
                            "depositpaid": true,
                            "bookingdates": {
                                "checkin": "2018-01-01",
                                "checkout": "2019-01-01"
                            },
                            "additionalneeds": "Breakfast"
                        }
    */

    @Test
    public void get18Pojo() {

        // 1. Set The URL
        spec.pathParams("first", "booking", "second", 18);

        // 2. Set The Expected Data ( put, post, patch)

        // 3. Send The Request And Get The Response

    }
}
