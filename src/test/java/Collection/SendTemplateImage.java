package Collection;

import Base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;

import static pojo.Constant.Constant.SearchUser_EndPoint;
import static pojo.Constant.Constant.SendNotification_EndPoint;
import static utility.RestCalls.*;
import static utility.Utility.fetchvalue;
import static utility.Utility.generateStringFromResource;

public class SendTemplateImage extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Notification 200")
    @Story("An Endpoint to Send Notification 200")
    public void SendTemplateImage_200() throws InterruptedException, IOException {
        RestAssured.baseURI = "https://qa-be.ebanqo.io/message/send/template";
        Response response = POST_200("/", generateStringFromResource("./src/main/java/Payload/SendImageTemplate.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Notification 401")
    @Story("An Endpoint to Send Notification 401")
    public void SendTemplateImage_401() throws InterruptedException, IOException {
        RestAssured.baseURI = "https://qa-be.ebanqo.io/message/send/template";
        Response response = POST_401("/", generateStringFromResource("./src/main/java/Payload/SendImageTemplate.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Notification 403")
    @Story("An Endpoint to send Notification 403")
    public void SendTemplateImage_403() throws InterruptedException, IOException {
        RestAssured.baseURI = "https://qa-be.ebanqo.io/message/send/template";
        Response response = POST_403("/", generateStringFromResource("./src/main/java/Payload/SendImageTemplate.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Template Image 400")
    @Story("An Endpoint to Send Template Image 400")
    public void SendTemplateImage_400() throws InterruptedException, IOException {
        Response response = POST_200(SendNotification_EndPoint, generateStringFromResource("./src/main/java/Payload/SearchUser.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertEquals(response.getStatusLine(), StatusLine_400);
    }
}
