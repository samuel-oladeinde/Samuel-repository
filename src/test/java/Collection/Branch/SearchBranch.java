package Collection.Branch;

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
import static pojo.Constant.Constant.SearchBranch_EndPoint;
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class SearchBranch extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Search Branch")
    @Story("An Endpoint to Search Branch")
    public void SearchBranch_200() throws InterruptedException, IOException {
        Response response = POST_200(SearchBranch_EndPoint, generateStringFromResource("./src/main/java/Payload/SearchBranch.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Search Branch 401")
    @Story("An Endpoint to Search Branch 401")
    public void SearchBranch_401() throws InterruptedException, IOException {
        Response response = POST_401(SearchBranch_EndPoint, generateStringFromResource("./src/main/java/Payload/SearchBranch.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Search Branch 403")
    @Story("An Endpoint to Search Branch 403")
    public void SearchBranch_403() throws InterruptedException, IOException {
        Response response = POST_403(SearchBranch_EndPoint, generateStringFromResource("./src/main/java/Payload/SearchBranch.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

}
