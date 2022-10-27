package Get_Request;

import Base_Url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get05 extends RestfulBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User sends get request to the URL
        Then
            Status code is 200
        And
            Among the data there should be someone whose firstname is "Johhny" and lastname is "Dear"
     */

    @Test
    public void get05() {

        // https://restful-booker.herokuapp.com/booking?firstname=Ali&lastname=Şen

        // 1. Set The URL
        spec.pathParam("first", "booking").
                queryParams("firstname", "Ali", "lastname", "Şen");

        // 2. Set The Expected Data

        // 3. Send The Request And Get The Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();


    }
}
