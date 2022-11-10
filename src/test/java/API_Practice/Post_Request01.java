package API_Practice;

import Base_Url.GMIBankBaseURL;
import Pojos.GMIBankCountryPostPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Post_Request01 extends GMIBankBaseURL {

    /*
    https://www.gmibank.com/api/tp-countries adrresine yeeni bir ülke ekelyin
    */

    @Test
    public void test10(){
        spec01.pathParam("first", "tp-countries");

        GMIBankCountryPostPojo GMIBankCountryPostPojo = new GMIBankCountryPostPojo("Batch81");
        System.out.println("countryPost = " + GMIBankCountryPostPojo);

        Response response = given()
                .headers("Authorization", "Bearer " + generateToken(), "Content-Type", ContentType.JSON)
                .spec(spec01).when().body(GMIBankCountryPostPojo)
                .post("/{first}");

        response.prettyPrint();

        GMIBankCountryPostPojo actualData = response.as(GMIBankCountryPostPojo.class);
        System.out.println("actualData = " + actualData);

        // Doğrulama Yaptık
        Assert.assertEquals(GMIBankCountryPostPojo.getName(), actualData.getName());
    }
}
