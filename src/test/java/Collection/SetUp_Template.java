package Collection;

import Base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.*;
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class SetUp_Template extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to SetUp_Template 200")
    @Story("An Endpoint to SetUp_Template 200")
    public void SetUp_Template_200() throws InterruptedException, IOException {
        Response response = POST_200(SetUPTemplate_EndPoint, generateStringFromResource("./src/main/java/Payload/SetUpTemplate.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to SetUp_Template 401")
    @Story("An Endpoint to SetUp_Template 401")
    public void SetUp_Template_401() throws InterruptedException, IOException {
        Response response = POST_401(SetUPTemplate_EndPoint, generateStringFromResource("./src/main/java/Payload/SetUpTemplate.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to SetUp_Template 403")
    @Story("An Endpoint to SetUp_Template 403")
    public void SetUp_Template_403() throws InterruptedException, IOException {
        Response response = POST_403(SetUPTemplate_EndPoint, generateStringFromResource("./src/main/java/Payload/SetUpTemplate.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to SetUp_Template 400")
    @Story("An Endpoint to SetUp_Template 400")
    public void SetUp_Template_400() throws InterruptedException, IOException {
        Response response = POST_200(SetUPTemplate_EndPoint, generateStringFromResource("./src/main/java/Payload/AddPhrase.json"));
        response.prettyPeek().then().spec(responseSpec_400);
    }
}
