package Collection.AutoAssign.Teams;

import Base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.CreateTeam_EndPoint;
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class CreateTeam extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Team 200")
    @Story("An Endpoint to Create Team 200")
    public void CreateTeam_200() throws InterruptedException, IOException {
        Response response = POST_200(CreateTeam_EndPoint, generateStringFromResource("./src/main/java/Payload/CreatTeam.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Team 401")
    @Story("An Endpoint to Create Team 401")
    public void CreateTeam_401() throws InterruptedException, IOException {
        Response response = POST_401(CreateTeam_EndPoint, generateStringFromResource("./src/main/java/Payload/CreatTeam.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Team 403")
    @Story("An Endpoint to Create Team 403")
    public void CreateTeam_403() throws InterruptedException, IOException {
        Response response = POST_403(CreateTeam_EndPoint, generateStringFromResource("./src/main/java/Payload/CreatTeam.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
