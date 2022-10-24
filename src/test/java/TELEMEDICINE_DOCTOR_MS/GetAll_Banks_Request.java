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

public class GetAll_Banks_Request extends TestBase{

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Get all banks)")
    @Story("1 Ensure that all created banks are retrieved fromm this endpoint")
    public void Get_All_Banks_Endpoint () throws InterruptedException, IOException {
        Response response = GET_200(Get_All_Banks_Endpoint);
        //Response response = GET_200(View_All_Doctors_Endpoint);
        response.prettyPeek().then().spec(responseSpec_200);



    }
}