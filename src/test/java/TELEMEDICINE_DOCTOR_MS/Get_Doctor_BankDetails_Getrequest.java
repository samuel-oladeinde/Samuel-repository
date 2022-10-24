package TELEMEDICINE_DOCTOR_MS;

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





public class Get_Doctor_BankDetails_Getrequest extends TestBase {


    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Get all doctors account usimng personreference")
    @Story("1 Ensure that all created banks are retrieved fromm this endpoint")
    public void Get_Doctor_Bank_Using_PersonReference_Endpoint() throws InterruptedException, IOException {
        Response response = GET_200(Get_Doctor_Bank_Using_PersonReference_Endpoint.concat("/480/bank-details"));
        response.prettyPeek().then().spec(responseSpec_200);
        assertEquals(response.jsonPath().getString("status"), "Success");

    }
}