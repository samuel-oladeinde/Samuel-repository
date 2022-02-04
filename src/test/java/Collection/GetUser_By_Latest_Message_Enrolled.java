package Collection;

import Base.TestBase;
import Response.GetUserEnrolled.Data;
import Response.GetUserEnrolled.Datum;
import Response.GetUserEnrolled.GetUserResponse;
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
import static pojo.Constant.Constant.*;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_404;

public class GetUser_By_Latest_Message_Enrolled extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get User By Latest Message Enrolled 200")
    @Story("An Endpoint to Get User By Latest Message Enrolled 200")
    public void GetUser_By_Latest_Message_Enrolled_200() throws InterruptedException, IOException {
        Response response = GET_200(GetUsersByLatestMessageEnrolled_EndPoint);

        GetUserResponse ResponsePojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(GetUserResponse.class);

        Data dat = ResponsePojo.getData();

        assertThat(dat.getPagination().getPage().toString(), is(not(emptyString())));
        assertThat(dat.getPagination().getPageCount().toString(), is(not(emptyString())));
        assertThat(dat.getPagination().getPageSize().toString(), is(not(emptyString())));
        assertThat(dat.getPagination().getRowCount().toString(), is(not(emptyString())));


        List<Datum> datt = ResponsePojo.getData().getData();

        for (Datum d : datt) {
            assertThat(d.getName(), is(not(emptyString())));
            System.out.println(d.getAgentId());
            //assertThat(d.getAgentId(), is(0));
            assertThat(d.getUserCode(), is(not(emptyString())));
            assertThat(d.getPlatform(), is(not(emptyString())));
            assertThat(d.getDate(), is(not(emptyString())));
        }
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get User By Latest Message Enrolled 401")
    @Story("An Endpoint to Get User By Latest Message Enrolled 401")
    public void GetUser_By_Latest_Message_Enrolled_401() throws InterruptedException, IOException {
        Response response = GET_401(GetUsersByLatestMessageEnrolled_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get User By Latest Message Enrolled 403")
    @Story("An Endpoint to Get User By Latest Message Enrolled 403")
    public void GetUser_By_Latest_Message_Enrolled_403() throws InterruptedException, IOException {
        Response response = GET_403(GetUsersByLatestMessageEnrolled_EndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get User By Latest Message Enrolled 404")
    @Story("An Endpoint to Get User By Latest Message Enrolled 404")
    public void GetUser_By_Latest_Message_Enrolled_404() throws InterruptedException, IOException {
        Response response = GET_200("/user/messages/recent/?agent_id=30000&platform=facebook&enrolled=true").prettyPeek();
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_404);
    }

}
