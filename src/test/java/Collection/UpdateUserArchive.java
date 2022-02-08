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
import static pojo.Constant.Constant.UpdateUserArchive_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;
import static utility.Utility.generateStringFromResource;

public class UpdateUserArchive extends TestBase {

    /*
    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update User Archive 200")
    @Story("An Endpoint to Update User Archive 200")
    public void UpdateUserArchive_200() throws InterruptedException, IOException {
        Response response = POST_200(UpdateUserArchive_EndPoint, generateStringFromResource("./src/main/java/Payload/UpdateUserArchieve.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }
*/

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update User Archive 400")
    @Story("An Endpoint to Update User Archive 400")
    public void UpdateUserArchive_400() throws InterruptedException, IOException {
        Response response = POST_200(UpdateUserArchive_EndPoint, generateStringFromResource("./src/main/java/Payload/UpdateUserArchieve.json"));
        response.prettyPeek().then().spec(responseSpec_400);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update User Archive 401")
    @Story("An Endpoint to Update User Archive 401")
    public void UpdateUserArchive_401() throws InterruptedException, IOException {
        Response response = POST_401(UpdateUserArchive_EndPoint, generateStringFromResource("./src/main/java/Payload/UpdateUserArchieve.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update User Archive 403")
    @Story("An Endpoint to Update User Archive 403")
    public void UpdateUserArchive_403() throws InterruptedException, IOException {
        Response response = POST_403(UpdateUserArchive_EndPoint, generateStringFromResource("./src/main/java/Payload/UpdateUserArchieve.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
