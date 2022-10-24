package Telemedicine_Enrollee_MS;
import Base.TestBase;
import Response.Add_Favourite_Pharmacy.Add_Favourite_Pharmacy_Response_Pojo;
import Response.doctor_signup_Response.Doctor_Signup_Response_Pojo;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static pojo.Constant.Constant.Add_favourite_Pharmacy_Endpoint;
import static pojo.Constant.Constant.Doctor_Signup_Endpoint;
import static pojo.PayloadManager.Add_Favourite_Pharmacy_Payload;
import static pojo.PayloadManager.Signup_doctor_Request;
import static utility.RestCalls.POST_201;

public class doctor_signup extends TestBase{
    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure that a new Pharmacy can be created")
    @Story("Ability to create new pharmacy, pharmacy should appear in the list of pharmacies")
    public void Doctor_Signup () throws InterruptedException, IOException {
        Response response = POST_201(Doctor_Signup_Endpoint,Signup_doctor_Request());

        Doctor_Signup_Response_Pojo ResponsePojo = response.prettyPeek().then().spec(responseSpec_201)
                .extract()
                .as(Doctor_Signup_Response_Pojo.class);
}
}
