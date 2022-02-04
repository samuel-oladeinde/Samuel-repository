package Collection;

import Base.TestBase;
import Response.GetNoMatcheMessage.Data;
import Response.GetNoMatcheMessage.Datum;
import Response.GetNoMatcheMessage.getNoMatcheMessageResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static pojo.Constant.Constant.GetNomatchedMessages_EndPoint;
import static utility.RestCalls.*;
import static utility.Utility.fetchvalue;

public class Get_No_Matched_Messages extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get_No_Matched_Messages 200")
    @Story("An Endpoint to Get_No_Matched_Messages 200")
    public void Get_No_Matched_Messages_200() throws InterruptedException, IOException {
        Response response = GET_200(GetNomatchedMessages_EndPoint);

        getNoMatcheMessageResponse ResponsePojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(getNoMatcheMessageResponse.class);

        Assertions.assertEquals(ResponsePojo.getStatus(), "success");

        Data dat = ResponsePojo.getData();

        assertThat(dat.getPagination().getPage().toString(), is(not(emptyString())));
        assertThat(dat.getPagination().getPageCount().toString(), is(not(emptyString())));
        assertThat(dat.getPagination().getPageSize().toString(), is(not(emptyString())));
        assertThat(dat.getPagination().getRowCount().toString(), is(not(emptyString())));


        List<Datum> datt = ResponsePojo.getData().getData();

        for (Datum d : datt) {
            assertThat(d.getName(), is(not(emptyString())));
            assertThat(d.getPlatform(), is(not(emptyString())));
            assertThat(d.getRequest(), is(not(emptyString())));
            assertThat(d.getResponse(), is(not(emptyString())));

            assertThat(d.getCreatedAt(), is(not(emptyString())));
            assertThat(d.getUser(), is(not(emptyString())));

            //   assertThat(d.getUserId().toString(), is(not(emptyString())));
            //  assertThat(d.getIsMatched().toString(), is(not(emptyString())));
            //   assertThat(d.getMatchDate().toString(), is(not(emptyString())));
            //  assertThat(d.getMatchType().toString(), is(not(emptyString())));

            //  assertThat(d.getMatchBy().toString(), is(not(emptyString())));
            //   assertThat(d.getAgentId().toString(), is(not(emptyString())));
            //  assertThat(d.getPlatform(), is(not(emptyString())));
        }
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get_No_Matched_Messages 401")
    @Story("An Endpoint to Get_No_Matched_Messages 401")
    public void Get_No_Matched_Messages_401() throws InterruptedException, IOException {
        RestAssured.baseURI = fetchvalue("gatewayUrl");
        Response response = GET_401(GetNomatchedMessages_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

}
