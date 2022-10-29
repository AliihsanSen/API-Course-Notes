package Get_Request;

import Base_Url.RestfulBaseUrl;
import org.junit.Test;

public class Get11 extends RestfulBaseUrl {

  /*
    Given
        https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
    When
        User sends get request to the URL
    Then
        Status code is 200
    And
         Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"

    */

    @Test
    public void get11() {

    }
}
