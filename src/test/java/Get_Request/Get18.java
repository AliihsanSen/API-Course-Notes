package Get_Request;

import Base_Url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Get18 extends GoRestBaseUrl {

    /*
    Given
        https://gorest.co.in/public/v1/users
    When
        User send GET Request
    Then
        The value of "pagination limit" is 10
    And
        The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
    And
        The number of users should  be 10
    And
        We have at least one "active" status
    And
        "Pres. Amarnath Dhawan","Sujata Chaturvedi","Navin Panicker" are among the users
    And
        The female users are less than or equals to male users
 */

    @Test
    public void get18() {

        // 1. Set The URL
        spec.pathParams("first", "users");

        // 2. Set The Expected Data ( put, post, patch)

        // 3. Send The Request And Get The Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        // 4. Do Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                body("meta.pagination.limit", equalTo(10),
                        "meta.pagination.links.current", equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data", hasSize(10), "data.status", hasItem("active"),
                        "data.name", hasItems("Pres. Amarnath Dhawan", "Sujata Chaturvedi", "Navin Panicker"));

        // Kadın ve Erkek sayılarını karşılaştıralım.

        // 1. YOL
        List<String> genders = response.jsonPath().getList("data.gender");

        int male = 0;
        int female = 0;
        for (String each : genders) {
            if (each.equalsIgnoreCase("female")) {
                female++;
            } else if (each.equalsIgnoreCase("male")) {
                male++;
            }
        }
        System.out.println("male = " + male);
        System.out.println("female = " + female);

        assertTrue(female <= genders.size() - female);

        // 2. YOL ==> Kadın ve Erkek sayılarını Grovy ile bulalım.
        List<String> femaleNames = response.jsonPath().getList("data.findAll{it.gender=='female'}.name");
        System.out.println("femaleNames = " + femaleNames);
    }
}
