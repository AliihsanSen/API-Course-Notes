package Get_Request;

import Base_Url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Get06 extends RestfulBaseUrl {

/*
        Given
            https://restful-booker.herokuapp.com/booking/2325
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
         {
    "firstname": "Bradley",
    "lastname": "Pearson",
    "totalprice": 132,
    "depositpaid": false,
    "bookingdates": { ==> Outer JSON
        "checkin": "2022-10-27", ==> Inner JSON
        "checkout": "2022-11-07" ==> Inner JSON
    },
    "additionalneeds": "None"
}
     */

    @Test
    public void get06() {

        // 1. Set The URL
        spec.pathParams("first", "booking", "second", 2325);

        // 2. Set The Expected Data (Put, Post and Patch)

        // 3. Send The Request And Get The Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // 4. Do Assertion

        // 1. YOL
        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Bradley"),
                        "lastname", equalTo("Pearson"),
                        "totalprice", equalTo(132),
                        "depositpaid", equalTo(false),
                        "bookingdates.checkin", equalTo("2022-10-27"),
                        "bookingdates.checkout", equalTo("2022-11-07"),
                        "additionalneeds", equalTo("None"));

        // 2. YOL : Jsonpath class'ının kullanimi.
        JsonPath json = response.jsonPath();
        assertEquals("Bradley", json.getString("firstname"));
        assertEquals("Pearson", json.getString("lastname"));
        assertEquals(132, json.getInt("totalprice"));
        assertFalse(json.getBoolean("depositpaid")); // ==> assertEquals(false,json.getBoolean("depositpaid"));
        assertEquals("2022-10-27", json.getString("bookingdates.checkin"));
        assertEquals("2022-11-07", json.getString("bookingdates.checkout"));
        assertEquals("None", json.getString("additionalneeds"));

        // 3. YOL : Soft Assertion
        // Soft Assert 3 adımda kullanılır.

        // i) Obje Olusturma
        SoftAssert softAssert = new SoftAssert();

        // ii) Do Assertion (doğrulama yapma)
        softAssert.assertEquals(json.getString("firstname"),"Bradley", "First Name Hatali");
        softAssert.assertEquals(json.getString("lastname"),"Pearson", "Last Name Hatali");
        softAssert.assertEquals(json.getInt("totalprice"),132,"Total Price Hatali");
        softAssert.assertEquals(json.getBoolean("depositpaid"),false,"Depositpaid Hatali");
        softAssert.assertEquals(json.getString("bookingdates.checkin"),"2022-10-27","Check In Tarihi Hatali");
        softAssert.assertEquals(json.getString("bookingdates.checkout"),"2022-11-07", "Check out Tarihi Hatali");
        softAssert.assertEquals(json.getString("additionalneeds"),"None", "Additionalneeds Hatali");
        softAssert.assertAll();
        /*
         iii) Dogrulama islemleri sonunda softAssert.assertAll() diyerek
         yaptigimiz tum dogrulama islemlerinin kontrol edilmesini sagliyoruz.
              Eger sistemin sonunda softAssert.assertAlll() kullanmaz isek taleplerimiz
         hatali olsa bile testimiz pass olacaktır.
             softAssert.assertAll();
         */

    }
}
