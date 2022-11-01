package Get_Request;

import org.junit.Test;

public class Get_Practice02 {

    @Test
    public void test02() {

        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);
        //given().when().get(url) -> request
        //Response response -> response

        //Header Test
        response.then().assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType(ContentType.JSON);

        //Body Test
        /* idsi 1 olanın datalarınının aşağıdaki gibi olduğunu test ediniz
             "email": "george.bluth@reqres.in",
            "first_name": "George",
            "last_name": "Bluth",
         */

    }
}
