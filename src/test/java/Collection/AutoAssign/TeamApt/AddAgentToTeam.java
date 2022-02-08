package Collection.AutoAssign.TeamApt;

import Base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.AddAgenttoTeam;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;
import static utility.Utility.generateStringFromResource;

public class AddAgentToTeam extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Add Agent To Team 200")
    @Story("An Endpoint to Add Agent To Team 200")
    public void AddAgentToTeam_200() throws InterruptedException, IOException {
        Response response = POST_200(AddAgenttoTeam, generateStringFromResource("./src/main/java/Payload/AddAgenttoteams.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Add Agent To Team 401")
    @Story("An Endpoint to Add Agent To Team 401")
    public void AddAgentToTeam_401() throws InterruptedException, IOException {
        Response response = POST_401(AddAgenttoTeam, generateStringFromResource("./src/main/java/Payload/AddAgenttoteams.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Add Agent To Team 403")
    @Story("An Endpoint to Add Agent To Team 403")
    public void AddAgentToTeam_403() throws InterruptedException, IOException {
        Response response = POST_403(AddAgenttoTeam, generateStringFromResource("./src/main/java/Payload/AddAgenttoteams.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
