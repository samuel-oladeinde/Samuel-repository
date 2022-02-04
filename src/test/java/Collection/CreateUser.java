package Collection;

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
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class CreateUser extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create User Base")
    @Story("An Endpoint to Create User Base")
    public void CreateUser_200() throws InterruptedException, IOException {
        Response response = POST_200(CreateUser_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateUser.json"));
        CreateUserResponse ResponsePojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(CreateUserResponse.class);

        Assertions.assertEquals(ResponsePojo.getStatus(), "success");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create User Base 401")
    @Story("An Endpoint to Create User Base 401")
    public void CreateUser_401() throws InterruptedException, IOException {
        Response response = POST_401(CreateUser_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateUser.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create User 403")
    @Story("An Endpoint to Create User 403")
    public void CreateUser_403() throws InterruptedException, IOException {
        Response response = POST_403(CreateUser_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateUser.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create User 400")
    @Story("An Endpoint to Create User 400")
    public void CreateUser_400() throws InterruptedException, IOException {
        Response response = POST_200(CreateUser_EndPoint, generateStringFromResource("./src/main/java/Payload/AddPhrase.json"));
        response.prettyPeek().then().spec(responseSpec_400);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertEquals(response.getStatusLine(), StatusLine_400);
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create User 409")
    @Story("An Endpoint to Create User 409")
    public void CreateUser_409() throws InterruptedException, IOException {
        Response response = POST_200(CreateUser_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateUser.json"));
        response.prettyPeek().then().spec(responseSpec_409);
    }
}
