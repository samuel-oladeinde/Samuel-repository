package Collection;

import Base.TestBase;
import Response.SaveChannel.SaveChannelResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import static Collection.List_KnowledgeBase.List_KnowledgeBase_200;
import static pojo.Constant.Constant.KnowledgeBase_EndPoint;
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class Create_KnowledgeBase extends TestBase {


    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Knowledge Base")
    @Story("An Endpoint to Create Knowledge Base")
    public void Create_KnowledgeBase_200() throws InterruptedException, IOException {
       //int a = Checker();

        Response response = POST_200(KnowledgeBase_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateKnowledgeBase.json"));

        SaveChannelResponse ResponsePojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(SaveChannelResponse.class);

        Assertions.assertEquals(ResponsePojo.getStatus(), "success");
        // Assertions.assertEquals(ResponsePojo.getData(), "Record Added Successfully");
      //  int b = Checker();
      //  System.out.println(a);
       // System.out.println(b);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Knowledge Base 401")
    @Story("An Endpoint to Create Knowledge Base 401")
    public void Create_KnowledgeBase_401() throws InterruptedException, IOException {
        Response response = POST_401(KnowledgeBase_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateKnowledgeBase.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Knowledge Base 403")
    @Story("An Endpoint to Create Knowledge Base 403")
    public void Create_KnowledgeBase_403() throws InterruptedException, IOException {
        Response response = POST_403(KnowledgeBase_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateKnowledgeBase.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check KnowledgeBase Creation")
    @Story("Check KnowledgeBase Creation")
    public void CheckKnowledgeBaseCreation() throws InterruptedException, IOException {
        List_KnowledgeBase_200();
    }
}
