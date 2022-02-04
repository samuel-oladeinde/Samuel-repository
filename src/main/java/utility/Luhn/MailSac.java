package utility.Luhn;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;

public class MailSac {

    public static Response GET_200(String uRI) throws InterruptedException {
        RestAssured.baseURI = "https://mailsac.com/api";

        return RestAssured.given().log().everything().header("Mailsac-Key", "k_452mMrw3dszV9MOpgheveolcZez0U7KE0").header("Content-Type",
                        ContentType.JSON)
                .when().get(uRI);
    }

    public static Response DELETE_200(String uRI) throws InterruptedException {
        RestAssured.baseURI = "https://mailsac.com/api";

        return RestAssured.given().log().everything().header("Mailsac-Key", "k_452mMrw3dszV9MOpgheveolcZez0U7KE0").header("Content-Type",
                        ContentType.JSON)
                .when().delete(uRI);
    }

    public static Response DELETE_20(String uRI) throws InterruptedException {
        RestAssured.baseURI = "https://mailsac.com/api";

        return RestAssured.given().log().everything().header("Mailsac-Key", "k_452mMrw3dszV9MOpgheveolcZez0U7KE0").header("Content-Type",
                        ContentType.JSON)
                .when().delete(uRI);
    }

    @Test
    public void GetMail() throws InterruptedException {
        RestAssured.baseURI = "https://mailsac.com/api";
        Response response = GET_200("/validations/addresses/ennymat25@mailsac.com");
        Assertions.assertEquals(response.prettyPeek().getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test
    public static String GetMailID(String email) throws InterruptedException {
        RestAssured.baseURI = "https://mailsac.com/api";
        Response response = GET_200("addresses/" + email + "/messages");
        Assertions.assertEquals(response.prettyPeek().getStatusCode(), RESPONSE_STATUS_CODE_200);
        return response.prettyPeek().then().extract().path("[0]._id");
    }


    public static String Gettoken(String email) throws InterruptedException {
        RestAssured.baseURI = "https://mailsac.com/api";
        Response response = GET_200("addresses/" + email + "/messages");
        Assertions.assertEquals(response.prettyPeek().getStatusCode(), RESPONSE_STATUS_CODE_200);
        String aa = response.prettyPeek().then().extract().response().body().path("[0].links[1]");
        String s = new String(aa);
        return s.substring(48);
    }
/*
    @Test
    public static Integer GetMailCount(String email) throws InterruptedException {
        RestAssured.baseURI = "https://mailsac.com/api";
        Response response = GET_200("/addresses/" + email + "/message-count");
        messagecount responsepojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(messagecount.class);
        return responsepojo.getCount();
    }



 */
    @Test
    public static void DeleteMailMessage(String email) throws InterruptedException {
        RestAssured.baseURI = "https://mailsac.com/api";
        Response response = DELETE_200("/addresses/" + email + "/messages/" + GetMailID(email));
        Assertions.assertEquals(response.prettyPeek().getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
