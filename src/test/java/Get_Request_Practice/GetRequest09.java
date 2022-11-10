package Get_Request_Practice;

import Base_Url.GMIBankBaseURL;
import Pojos.GMIBankCountryPojo;
import Pojos.GMIBankCustomerPojo;
import Pojos.GMIBankUserPojo;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest09 extends GMIBankBaseURL {
     /*
    http://www.gmibank.com/api/tp-customers/110452
     */

    @Test
    public void test09() {

        spec01.pathParams("bir", "tp-customers", "iki", 110452);

        //EXPECTED DATA
        /*
            /*
        "user": {
        "id": 110016,
        "login": "leopoldo.reinger",
        "firstName": "Jasmine",
        "lastName": "Stehr",
        "email": "marni.zboncak@yahoo.com",
        "activated": true,
        "langKey": "en",
        "imageUrl": null,
        "resetDate": null
    }
     */

        //Account [] accounts;
        GMIBankUserPojo GMIBankUserPojo = new GMIBankUserPojo(110016, "leopoldo.reinger", "Jasmine", "Stehr",
                "marni.zboncak@yahoo.com", true, "en", null, null);

        GMIBankCountryPojo GMIBankCountryPojo = new GMIBankCountryPojo(3, "USA", null);

        GMIBankCustomerPojo expectedData = new GMIBankCustomerPojo(110452, "Jasmine", "Stehr", "V", "marni.zboncak@yahoo.com"
                , "463-609-2097", "1-112-497-0270", "16525", "14387 Al Ridge5343 Bert Burgs", "Waltermouth"
                , "761-59-2911", "2021-11-28T21:00:00Z", false, GMIBankCountryPojo, "California", GMIBankUserPojo);

        System.out.println("expectedData = " + expectedData);

        Response response = given().spec(spec01).headers("Authorization", "Bearer " + generateToken())
                .when()
                .get("/{bir}/{iki}");
        response.prettyPrint();

        GMIBankCustomerPojo actualData = response.as(GMIBankCustomerPojo.class);
        System.out.println(actualData);

    }
}
