
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class telemedicineMS {




    @Test
    void test1(){

        Response response = RestAssured.get("https://dev.daara-services.reliancehmo.com/providerservice/api/providers");
        System.out.println("Response : "+response.asString());

    }

    @Test
    public void  getId() {
        RestAssured.baseURI = "https://dev.daara-services.reliancehmo.com";
        Response response = given()
                .contentType("application/json")
                .body("{\n    \"login\": \"super.admin@reliancehmo.com\",\n    \"password\":\"reliance\"\n}")
                .when()
                .post("/accountservice/api/signin")
                .then()
                .extract().response();
        String body = response.getBody().asString();
        System.out.println(body);

    }

}



