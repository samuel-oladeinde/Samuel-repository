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
import static pojo.Constant.Constant.GetTransactionLagWebhook_EndPoint;
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class TransactionLogWebhook extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Transaction Log Webhook")
    @Story("An Endpoint to Get Transaction Log Webhook")
    public void TransactionLogWebhook_200() throws InterruptedException, IOException {
        Response response = POST_200(GetTransactionLagWebhook_EndPoint, generateStringFromResource("./src/main/java/Payload/transactionLoag.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }
}
