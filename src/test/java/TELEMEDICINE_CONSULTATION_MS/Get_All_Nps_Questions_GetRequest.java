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

public class Get_All_Nps_Questions_GetRequest extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to view all NPS Questions")
    @Story("An Endpoint to view enrollee consultation History using enrollee user ID")
    public void View_Enrollee_Consultation_History_BYID() throws InterruptedException, IOException {
        Response response = GET_200(View_All_Nps_Questions_Endpoint);
        response.prettyPeek().then().spec(responseSpec_200);

    }
}