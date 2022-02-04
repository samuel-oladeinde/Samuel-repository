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
import static pojo.Constant.Constant.AddPhrase_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;
import static utility.Utility.generateStringFromResource;

public class AddPhraseTo_Service extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Add Phrase To Service 200")
    @Story("An Endpoint to Add Phrase To Service 200")
    public void AddPhraseTo_Service_200() throws InterruptedException, IOException {
        Response response = PUT_200(AddPhrase_EndPoint, generateStringFromResource("./src/main/java/Payload/AddPhrase.json"));
        response.prettyPeek().then().spec(responseSpec_200);
        Assertions.assertEquals(response.path("status").toString(), "success");
        Assertions.assertEquals(response.path("data").toString(), "Service Updated Successfully");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Add Phrase To Service 401")
    @Story("An Endpoint to Add Phrase To Service 401")
    public void Add_Phrase_To_Service_401() throws InterruptedException, IOException {
        Response response = POST_401(AddPhrase_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateKnowledgeBase.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Add Phrase To Service 403")
    @Story("An Endpoint to Add Phrase To Service 403")
    public void Add_Phrase_To_Service_403() throws InterruptedException, IOException {
        Response response = POST_403(AddPhrase_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateKnowledgeBase.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
