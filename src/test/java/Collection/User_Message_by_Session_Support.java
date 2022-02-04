package Collection;

import Base.TestBase;
import Response.UserMessage.Create;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.users_messagesBot_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;
import static utility.Utility.generateStringFromResource;

public class User_Message_by_Session_Support extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to fetch user message support 200")
    @Story("An Endpoint to fetch user message support 200")
    public void User_Message_by_Session_Support_200() throws InterruptedException, IOException {
        Response response = POST_200(users_messagesBot_EndPoint, generateStringFromResource("./src/main/java/Payload/usermessagesupport.json"));

        Create ResponsePojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(Create.class);

        Assertions.assertEquals(ResponsePojo.getStatus(), "success");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to fetch user message support 401")
    @Story("An Endpoint to fetch user message support 401")
    public void User_Message_by_Session_Support_401() throws InterruptedException, IOException {
        Response response = POST_401(users_messagesBot_EndPoint, generateStringFromResource("./src/main/java/Payload/usermessagesupport.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to fetch user message support  403")
    @Story("An Endpoint to fetch user message support 403")
    public void User_Message_by_Session_Support_403() throws InterruptedException, IOException {
        Response response = POST_403(users_messagesBot_EndPoint, generateStringFromResource("./src/main/java/Payload/usermessagesupport.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
