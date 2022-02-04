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
import static pojo.Constant.Constant.GettrainingSet_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;

public class GetTrainingSet_Intent extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get TrainingSet Intent 200")
    @Story("An Endpoint to Get TrainingSet Intent 200")
    public void GetTrainingSet_Intent_200() throws InterruptedException, IOException {
        Response response = GET_200(GettrainingSet_EndPoint);
        response.prettyPeek().then().spec(responseSpec_200);
        Assertions.assertEquals(response.path("status").toString(), "success");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get TrainingSet Intent 401")
    @Story("An Endpoint to Get TrainingSet Intent 401")
    public void GetTrainingSet_Intent_401() throws InterruptedException {
        Response response = GET_401(GettrainingSet_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get TrainingSet Intent 403")
    @Story("An Endpoint to Get TrainingSet Intent 403")
    public void GetTrainingSet_Intent_403() throws InterruptedException, IOException {
        Response response = GET_403(GettrainingSet_EndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
