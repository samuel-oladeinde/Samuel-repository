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
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class SendTemplateMessageInteractiveText extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Notification 200")
    @Story("An Endpoint to Send Notification 200")
    public void SendTemplateMessageInteractiveText_200() throws InterruptedException, IOException {
        RestAssured.baseURI = "https://qa-be.ebanqo.io/message/send/template";
        Response response = POST_200("/", generateStringFromResource("./src/main/java/Payload/SendTemplateTex.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Notification 401")
    @Story("An Endpoint to Send Notification 401")
    public void SendTemplateMessageInteractiveText_401() throws InterruptedException, IOException {
        RestAssured.baseURI = "https://qa-be.ebanqo.io/message/send/template";
        Response response = POST_401("/", generateStringFromResource("./src/main/java/Payload/SendTemplateTex.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Notification 403")
    @Story("An Endpoint to send Notification 403")
    public void SendTemplateMessageInteractiveText_403() throws InterruptedException, IOException {
        RestAssured.baseURI = "https://qa-be.ebanqo.io/message/send/template";
        Response response = POST_403("/", generateStringFromResource("./src/main/java/Payload/SendTemplateTex.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
