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
import static pojo.Constant.Constant.UpdateTeam_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;
import static utility.Utility.generateStringFromResource;

public class UpdateTeam extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update team 400")
    @Story("An Endpoint to Update Team 400")
    public void UpdateTeam_400() throws InterruptedException, IOException {
        Response response = PUT_200(UpdateTeam_EndPoint, generateStringFromResource("./src/main/java/Payload/UpdateTeam.json"));
        response.prettyPeek().then().spec(responseSpec_400);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update Team 401")
    @Story("An Endpoint to Update Team 401")
    public void UpdateTeam_401() throws InterruptedException, IOException {
        Response response = POST_401(UpdateTeam_EndPoint, generateStringFromResource("./src/main/java/Payload/CreatTeam.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update Team 403")
    @Story("An Endpoint to Update Team 403")
    public void UpdateTeam_403() throws InterruptedException, IOException {
        Response response = POST_403(UpdateTeam_EndPoint, generateStringFromResource("./src/main/java/Payload/CreatTeam.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update Team 403")
    @Story("An Endpoint to Update Team 403")
    public void UpdateTeam_404() throws InterruptedException, IOException {
        Response response = PUT_200(CreateTeam_EndPoint, generateStringFromResource("./src/main/java/Payload/CreatTeam.json"));
        response.prettyPeek();
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_404);
    }
}
