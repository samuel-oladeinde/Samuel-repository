package Collection;

import Base.TestBase;
import Response.GetIntentResponse.Datum;
import Response.GetIntentResponse.GetIntentResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static pojo.Constant.Constant.GetUserInfo_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;

public class GetUserInfo extends TestBase {

    /*
    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get User Information 200")
    @Story("An Endpoint to Get User Information 200")
    public void GetUserInfo_200() throws InterruptedException, IOException {
        Response response = GET_200(GetUserInfo_EndPoint);

        GetIntentResponse ResponsePojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(GetIntentResponse.class);

        Assertions.assertEquals(ResponsePojo.getStatus(), "success");

        List<Datum> datt = ResponsePojo.getData();

        for (Datum d : datt) {
            System.out.println(d.getName());
            System.out.println(d.getAgentId());

            assertThat(d.getName(), is(not(emptyString())));
            assertThat(d.getId().toString(), is(not(emptyString())));
            assertThat(d.getProcessAgent(), is(not(emptyString())));

            assertThat(d.getLabel(), is(not(emptyString())));
            assertThat(d.getCreatedAt(), is(not(emptyString())));
        }
    }
     */

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to User Information 401")
    @Story("An Endpoint to get User Information 401")
    public void GetUserInfo_401() throws InterruptedException, IOException {
        Response response = GET_401(GetUserInfo_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get User Information 403")
    @Story("An Endpoint to User Information 403")
    public void GetUserInfo_403() throws InterruptedException, IOException {
        Response response = GET_403(GetUserInfo_EndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
