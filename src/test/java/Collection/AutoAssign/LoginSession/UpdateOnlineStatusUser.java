package Collection.AutoAssign.LoginSession;

import Base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.UpdateOnlineStatusUser_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;
import static utility.Utility.generateStringFromResource;

public class UpdateOnlineStatusUser extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update online Status User 200")
    @Story("An Endpoint to Update online Status User 200")
    public void UpdateOnlineStatusUser_200() throws InterruptedException, IOException {
        Response response = PUT_200(UpdateOnlineStatusUser_EndPoint, generateStringFromResource("./src/main/java/Payload/UpdateOnlineStatusUser.json"));
        response.prettyPeek().then().spec(responseSpec_200);
        Assertions.assertEquals(response.path("status").toString(), "success");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update online Status User 401")
    @Story("An Endpoint to Update online Status User 401")
    public void UpdateOnlineStatusUser_401() throws InterruptedException, IOException {
        Response response = PUT_401(UpdateOnlineStatusUser_EndPoint, generateStringFromResource("./src/main/java/Payload/UpdateOnlineStatusUser.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update Online Status of User 403")
    @Story("An Endpoint to Update Online Status of User 403")
    public void UpdateOnlineStatusUser_403() throws InterruptedException, IOException {
        Response response = PUT_403(UpdateOnlineStatusUser_EndPoint, generateStringFromResource("./src/main/java/Payload/UpdateOnlineStatusUser.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
