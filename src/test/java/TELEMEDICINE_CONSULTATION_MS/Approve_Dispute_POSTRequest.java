package TELEMEDICINE_CONSULTATION_MS;

import Base.TestBase;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static pojo.Constant.Constant.*;
import static utility.RestCalls.GET_200;

public class Approve_Dispute_POSTRequest extends TestBase{


    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to approve dispute")
    @Story("An Endpoint to approve dispute")
    public void Approve_Dispute() throws InterruptedException, IOException {
        Response response = GET_200(Approve_Dispute_Endpoint.concat("/653/approve-dispute"));
        response.prettyPeek().then().spec(responseSpec_200);
}
}
