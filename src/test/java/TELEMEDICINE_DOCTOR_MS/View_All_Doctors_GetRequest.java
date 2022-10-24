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

public class View_All_Doctors_GetRequest extends TestBase {
    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("1. An Endpoint to view list of ALL doctors" +
            "2. An endpoint to view doctor details by ID)")
    @Story("1 Ensure that all created doctors are retrieved on the response payload")
    public void View_DoctorById_GetRequest() throws InterruptedException, IOException {
        Response response = GET_200(View_All_Doctors_Endpoint);
        response.prettyPeek().then().spec(responseSpec_200);
    }




    }
