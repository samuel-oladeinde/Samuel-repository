package TELEMEDICINE_DOCTOR_MS;

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

public class View_Doctor_ByID_GetRequest extends TestBase {



    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to view doctors transaction history)")
    @Story("Ensure that record of doctors transaction history is fetched")
    public void View_Doctor_TransactionHiostory() throws InterruptedException, IOException {
        Response response = GET_200(View_Doctor_Transaction_History_Endpoint.concat("/16"));
        response.prettyPeek().then().spec(responseSpec_200);

    }


}


