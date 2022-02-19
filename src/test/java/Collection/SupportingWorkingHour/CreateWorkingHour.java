package Collection.SupportingWorkingHour;

import Base.TestBase;
import Response.CreateUser.CreateUserResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.CreateUser_EndPoint;
import static pojo.Constant.Constant.CreateWorkingHour_EndPoint;
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class CreateWorkingHour extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Working Hour Base")
    @Story("An Endpoint to Create Working Hour Base")
    public void CreateWorkingHour_200() throws InterruptedException, IOException {
        Response response = POST_200(CreateWorkingHour_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateWorkingHour.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Working Hour 401")
    @Story("An Endpoint to Create Working Hour 401")
    public void CreateWorkingHour_401() throws InterruptedException, IOException {
        Response response = POST_401(CreateWorkingHour_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateWorkingHour.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Working Hour 403")
    @Story("An Endpoint to Create Working Hour 403")
    public void CreateWorkingHour_403() throws InterruptedException, IOException {
        Response response = POST_403(CreateWorkingHour_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateWorkingHour.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Working Hour 400")
    @Story("An Endpoint to Create Working Hour 400")
    public void CreateWorkingHour_400() throws InterruptedException, IOException {
        Response response = POST_200(CreateWorkingHour_EndPoint, generateStringFromResource("./src/main/java/Payload/AddPhrase.json"));
        response.prettyPeek().then().spec(responseSpec_400);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertEquals(response.getStatusLine(), StatusLine_400);
    }
}
