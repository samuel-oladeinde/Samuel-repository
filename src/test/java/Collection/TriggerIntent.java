package Collection;

import Base.TestBase;
import Response.CreateUser.CreateUserResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.testng.AllureTestNgTestFilter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.CreateUser_EndPoint;
import static pojo.Constant.Constant.TriggerIntent_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.POST_200;
import static utility.Utility.generateStringFromResource;

public class TriggerIntent extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Trigger intent 200")
    @Story("An Endpoint to Trigger intent 200")
    public void TriggerIntent_200() throws InterruptedException, IOException {
        Response response = POST_200(TriggerIntent_EndPoint, generateStringFromResource("./src/main/java/Payload/triggerintent.json"));
        response.prettyPeek().then().spec(responseSpec_200);
        Assertions.assertEquals(response.path("status").toString(), "success");
        Assertions.assertEquals(response.path("data").toString(), "Intent Triggered Successfully");

    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Trigger intent 401")
    @Story("An Endpoint to trigger intent 401")
    public void TriggerIntent_401() throws InterruptedException, IOException {
        Response response = POST_401(CreateUser_EndPoint, generateStringFromResource("./src/main/java/Payload/triggerintent.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to trigger intent 403")
    @Story("An Endpoint to trigger intent 403")
    public void TriggerIntent_403() throws InterruptedException, IOException {
        Response response = POST_403(TriggerIntent_EndPoint, generateStringFromResource("./src/main/java/Payload/triggerintent.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to trigger intent 400")
    @Story("An Endpoint to trigger intent 400")
    public void TriggerIntent_400() throws InterruptedException, IOException {
        Response response = POST_200(TriggerIntent_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateUser.json"));
        response.prettyPeek().then().spec(responseSpec_400);
    }
}
