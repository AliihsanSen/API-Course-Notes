package API_Practice;

import Base_Url.GMIBankBaseURL;
import Pojos.GMIBankCountryPojo;
import Pojos.GMIBankCustomerPojo;
import Pojos.GMIBankUserPojo;
import Utils.JsonUtil;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get_Request09 extends GMIBankBaseURL {
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
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getMiddleInitial(), actualData.getMiddleInitial());
        assertEquals(expectedData.getEmail(), actualData.getEmail());
        assertEquals(expectedData.getMobilePhoneNumber(), actualData.getMobilePhoneNumber());
        assertEquals(expectedData.getPhoneNumber(), actualData.getPhoneNumber());
        assertEquals(expectedData.getZipCode(), actualData.getZipCode());
        assertEquals(expectedData.getAddress(), actualData.getAddress());
        assertEquals(expectedData.getCity(), actualData.getCity());
        assertEquals(expectedData.getSsn(), actualData.getSsn());
        assertEquals(expectedData.getCreateDate(), actualData.getCreateDate());
        assertEquals(expectedData.isZelleEnrolled(), actualData.isZelleEnrolled());
        assertEquals(expectedData.getCountry().getId(), actualData.getCountry().getId());
        assertEquals(expectedData.getCountry().getName(), actualData.getCountry().getName());
        assertEquals(expectedData.getCountry().getStates(), actualData.getCountry().getStates());
        assertEquals(expectedData.getState(), actualData.getState());
        assertEquals(expectedData.getUser().getId(), actualData.getUser().getId());
        assertEquals(expectedData.getUser().getLogin(), actualData.getUser().getLogin());
        assertEquals(expectedData.getUser().getFirstName(), actualData.getUser().getFirstName());
        assertEquals(expectedData.getUser().getLastName(), actualData.getUser().getLastName());
        assertEquals(expectedData.getUser().getEmail(), actualData.getUser().getEmail());
        assertEquals(expectedData.getUser().getLangKey(), actualData.getUser().getLangKey());
        assertEquals(expectedData.getUser().getImageUrl(), actualData.getUser().getImageUrl());
        assertEquals(expectedData.getUser().getResetDate(), actualData.getUser().getResetDate());

        // Object Mapper
        GMIBankCustomerPojo actualData2 = JsonUtil.convertJsonToJava(response.asString(), GMIBankCustomerPojo.class);
        System.out.println("actualData2 = " + actualData2);

        assertEquals(expectedData.getId(), actualData2.getId());
        assertEquals(expectedData.getUser().getLogin(), actualData2.getUser().getLogin());
        assertEquals(expectedData.getCountry().getName(), actualData2.getCountry().getName());
    }
}
