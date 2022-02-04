package Collection;

import Base.TestBase;
import Response.SaveChannel.SaveChannelResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.SaveChannel_EndPoint;
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class SaveChannel extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Save chat Channel")
    @Story("An Endpoint to Save chat Channel")
    public void SaveChannel_200() throws InterruptedException, IOException {
        Response response = POST_200(SaveChannel_EndPoint, generateStringFromResource("./src/main/java/Payload/SaveChannel.json"));

        SaveChannelResponse ResponsePojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(SaveChannelResponse.class);

        Assertions.assertEquals(ResponsePojo.getStatus(), "success");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Save chat Channel 401")
    @Story("An Endpoint to Save chat Channel 401")
    public void SaveChannel_401() throws InterruptedException, IOException {
        Response response = POST_401(SaveChannel_EndPoint, generateStringFromResource("./src/main/java/Payload/SaveChannel.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Save chat Channel 403")
    @Story("An Endpoint to Save chat Channel 403")
    public void SaveChannel_403() throws InterruptedException, IOException {
        Response response = POST_403(SaveChannel_EndPoint, generateStringFromResource("./src/main/java/Payload/SaveChannel.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

}

