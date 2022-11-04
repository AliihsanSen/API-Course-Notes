package Get_Request;

import Base_Url.RestfulBaseUrl;
import Pojos.BookingDatesPojo;
import org.junit.Test;

public class Get19Pojo extends RestfulBaseUrl {

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
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01", "2019-01-01");
        System.out.println(bookingDatesPojo.toString());
        // 3. Send The Request And Get The Response

    }
}
