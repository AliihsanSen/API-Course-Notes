package Get_Request;

import Base_Url.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get23 extends DummyRestApiBaseUrl {
    /*
          URL: https://dummy.restapiexample.com/api/v1/employees
          HTTP Request Method: GET Request
          Test Case: Type by using Gherkin Language
          Assert:  i) Status code is 200
                  ii) There are 24 employees
                 iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                  iv) The greatest age is 66
                   v) The name of the lowest age is "Tatyana Fitzpatrick"
                  vi) Total salary of all employees is 6,644,770
   */
    /*
    Given
        https://dummy.restapiexample.com/api/v1/employees
    When
        user sends GET request
    Then
        i) Status code is 200
    And
        ii) There are 24 employees
    And
        iii) "Tiger Nixon" and "Garrett Winters" are among the employees
    And
        iv) The greatest age is 66
    And
         v) The name of the lowest age is "Tatyana Fitzpatrick"
    And
        vi) Total salary of all employees is 6,644,770
     */
    @Test
    public void get01() {

        // Set the Url
        spec.pathParams("first", "employees");

        // Set the expected data

        // Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        // Do assertion
        response.then().assertThat().body("data.id", hasSize(24),
                "data.employee_name", hasItems("Tiger Nixon", "Garrett Winters"));

        List<Integer> ages = response.jsonPath().getList("data.employee_age");
        System.out.println("ages = " + ages);
        Collections.sort(ages);
        System.out.println("Sorted ages = " + ages);

        System.out.println("En büyük yaşta çalışan : "+ages.get(ages.size() - 1));

    }
}