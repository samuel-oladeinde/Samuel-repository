package TELEMEDICINE_CONSULTATION_MS;

import Base.TestBase;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static pojo.Constant.Constant.*;
import static utility.RestCalls.GET_200;

public class Decline_Dispute_POSTRequest extends TestBase {
    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to decline dispute")
    @Story("An Endpoint to decline dispute")
    public void Decline_Dispute() throws InterruptedException, IOException {
        Response response = GET_200(Decline_Dispute_Endpoint.concat("/653/decline-dispute"));
        response.prettyPeek().then().spec(responseSpec_200);
    }
}