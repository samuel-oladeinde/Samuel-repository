package Collection;

import Base.TestBase;
import Response.GetChannel.GetChannelResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.GetKnowledgeBase400_EndPoint;
import static pojo.Constant.Constant.GetKnowledgeBase_EndPoint;
import static utility.RestCalls.*;

public class List_KnowledgeBase extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to List all Knowledge Base 200")
    @Story("An Endpoint to List all Knowledge Base 200")
    public void List_KnowledgeBase_200() throws InterruptedException, IOException {
        Response response = GET_200(GetKnowledgeBase_EndPoint);

        GetChannelResponse ResponsePojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(GetChannelResponse.class);

        Assertions.assertEquals(ResponsePojo.getStatus(), "success");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to List all Knowledge Base 401")
    @Story("An Endpoint to List all Knowledge Base 401")
    public void List_KnowledgeBase_401() throws InterruptedException, IOException {
        Response response = GET_401(GetKnowledgeBase_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to List all Knowledge Base 403")
    @Story("An Endpoint to List all Knowledge Base 403")
    public void List_KnowledgeBase_403() throws InterruptedException, IOException {
        Response response = GET_403(GetKnowledgeBase_EndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to List all Knowledge Base 400")
    @Story("An Endpoint to List all Knowledge Base 400")
    public void List_KnowledgeBase_400() throws InterruptedException, IOException {
        Response response = GET_200(GetKnowledgeBase400_EndPoint).prettyPeek();
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
    }
}
