package Collection.AutoAssign.Issuetype;

import Base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.CreateIssueType;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;
import static utility.Utility.generateStringFromResource;

public class CreateIssueTypes extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Issue Types 200")
    @Story("An Endpoint to Create Issue Types 200")
    public void CreateIssueTypes_200() throws InterruptedException, IOException {
        Response response = POST_200(CreateIssueType, generateStringFromResource("./src/main/java/Payload/CreateIssuetype.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Issue Types 401")
    @Story("An Endpoint to Create Issue Types 401")
    public void CreateIssueTypes_401() throws InterruptedException, IOException {
        Response response = POST_401(CreateIssueType, generateStringFromResource("./src/main/java/Payload/CreatTeam.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Issue Types 403")
    @Story("An Endpoint to Create Issue Types 403")
    public void CreateIssueTypes_403() throws InterruptedException, IOException {
        Response response = POST_403(CreateIssueType, generateStringFromResource("./src/main/java/Payload/CreatTeam.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
