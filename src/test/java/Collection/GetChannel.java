package Collection;

import Base.TestBase;
import Response.GetChannel.GetChannelResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.SaveChannel_EndPoint;
import static utility.RestCalls.*;
import static utility.Utility.fetchvalue;
import static utility.Utility.generateStringFromResource;

public class GetChannel extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get all chat Channel 200")
    @Story("An Endpoint to get all chat Channel 200")
    public void SaveChannel_200() throws InterruptedException, IOException {
        RestAssured.baseURI = fetchvalue("gatewayUrl");
        Response response = GET_200(SaveChannel_EndPoint);

        GetChannelResponse ResponsePojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(GetChannelResponse.class);

        Assertions.assertEquals(ResponsePojo.getStatus(), "success");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get all chat Channel 401")
    @Story("An Endpoint to get all chat Channel 401")
    public void Get_All_Channel_401() throws InterruptedException, IOException {
        RestAssured.baseURI = fetchvalue("gatewayUrl");
        Response response = GET_401(SaveChannel_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get all chat Channel 403")
    @Story("An Endpoint to get all chat Channel 403")
    public void SaveChannel_403() throws InterruptedException, IOException {
        RestAssured.baseURI = fetchvalue("gatewayUrl");
        Response response = POST_403(SaveChannel_EndPoint, generateStringFromResource("./src/main/java/Payload/SaveChannel.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
