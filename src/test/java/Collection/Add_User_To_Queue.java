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
import static pojo.Constant.Constant.AddUserToQueue_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;
import static utility.Utility.generateStringFromResource;

public class Add_User_To_Queue extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Add User To Queue 200")
    @Story("An Endpoint to Add User To Queue 200")
    public void Add_User_To_Queue_200() throws InterruptedException, IOException {
        Response response = POST_200(AddUserToQueue_EndPoint, generateStringFromResource("./src/main/java/Payload/AddUserQueuePayload.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Add User To Queue 401")
    @Story("An Endpoint to Add User To Queue 401")
    public void Add_User_To_Queue_401() throws InterruptedException, IOException {
        Response response = POST_401(AddUserToQueue_EndPoint, generateStringFromResource("./src/main/java/Payload/AddUserQueuePayload.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Add User To Queue 403")
    @Story("An Endpoint to Add User To Queue 403")
    public void Add_User_To_Queue_403() throws InterruptedException, IOException {
        Response response = POST_403(AddUserToQueue_EndPoint, generateStringFromResource("./src/main/java/Payload/AddUserQueuePayload.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Add User To Queue 404")
    @Story("An Endpoint to Add User To Queue 404")
    public void Add_User_To_Queue_404() throws InterruptedException, IOException {
        Response response = PUT_200(AddUserToQueue_EndPoint, generateStringFromResource("./src/main/java/Payload/AddUserQueuePayload.json"));
        response.prettyPeek().then().spec(responseSpec_404);
    }
}
