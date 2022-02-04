package Collection;

import Base.TestBase;
import Response.SearchUser.SearchUserResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.SearchUser_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;
import static utility.Utility.generateStringFromResource;

public class SearchUser extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Search User 200")
    @Story("An Endpoint to Search User 200")
    public void SearchUser_200() throws InterruptedException, IOException {
        Response response = POST_200(SearchUser_EndPoint, generateStringFromResource("./src/main/java/Payload/SearchUser.json"));

        SearchUserResponse ResponsePojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(SearchUserResponse.class);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Search User 401")
    @Story("An Endpoint to Search User 401")
    public void SearchUser_401() throws InterruptedException, IOException {
        Response response = POST_401(SearchUser_EndPoint, generateStringFromResource("./src/main/java/Payload/SearchUser.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Search User 403")
    @Story("An Endpoint to Search User 403")
    public void SearchUser_403() throws InterruptedException, IOException {
        Response response = POST_403(SearchUser_EndPoint, generateStringFromResource("./src/main/java/Payload/SearchUser.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
