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

public class Enrollee_AcceptClose_Consultation_POSTRequest extends TestBase{

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to view all NPS Questions")
    @Story("An Endpoint to view enrollee consultation History using enrollee user ID")
    public void Enrollee_Accept_ToClose_Consultation() throws InterruptedException, IOException {
        Response response = GET_200(Enrollee_Accepts_ToCloseConsultation_Endpoint.concat("/653/closed/true"));
        response.prettyPeek().then().spec(responseSpec_200);

    }
}






