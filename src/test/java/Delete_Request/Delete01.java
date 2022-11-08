package Delete_Request;

import Base_Url.JsonplaceholderBaseUrl;

public class Delete01 extends JsonplaceholderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void delete01(){

        // Set the Url
        spec.pathParams("first","todos","second",198);

        // Set the expected data
        Map<String,String> expectedData = new HashMap<>();

        // Send the Request and Get the Response
        Response response = given().spec(spec).when().delete("/{first}/{second}");

        // Do Assertion
        Map actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);

        assertEquals(200,response.getStatusCode());

        // 1. Yol
        assertEquals(expectedData, actualData);

        // 2. Yol
        assertTrue(actualData.isEmpty());

        // 3. Yol
        assertEquals(0,actualData.size());

    }

}
