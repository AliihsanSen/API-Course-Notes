package Get_Request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get_Practice02 {

    @Test
    public void test02() {

        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);
        // given().when().get(url) -> request
        // Response response -> response

        // Header Test
        response.then().assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType(ContentType.JSON);

        // Body Test
        /* id'si 1 olanın datalarınının aşağıdaki gibi olduğunu test ediniz
             "email": "george.bluth@reqres.in",
            "first_name": "George",
            "last_name": "Bluth",
         */

        // 3)Matcher Class ile
        response.then()
                .body("data[0].id",equalTo(1))
                .body("data[0].email",equalTo("george.bluth@reqres.in"))
                .body("data[0].first_name",equalTo("George"))
                .body("data[0].last_name",equalTo("Bluth"));

    }
}
