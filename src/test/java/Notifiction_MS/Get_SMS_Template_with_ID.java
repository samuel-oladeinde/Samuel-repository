package Notifiction_MS;

import Base.TestBase;
import Response.Get_SMS_Template_Invalid_ID_Pojo.Get_SMS_Template_Invalid_ID_Pojo;
import Response.Get_Template_Response_Pojo.Get_Template_Response_Pojo;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.testng.Assert.assertEquals;
import static pojo.Constant.Constant.Get_sms_template_ID_EndPoint;
import static pojo.Constant.Constant.Get_sms_template_Invalid_ID_EndPoint;
import static utility.RestCalls.GET_200;
import static utility.RestCalls.GET_401;

public class Get_SMS_Template_with_ID extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure `User is able to get SMS Template Using ID")
    @Story("Get SMS Template Using ID")
    public void Get_SMS_Template_Using_ID() throws InterruptedException, IOException {
        Response response = GET_200(Get_sms_template_ID_EndPoint);
        Get_Template_Response_Pojo ResponsePojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(Get_Template_Response_Pojo.class);

        assertEquals(ResponsePojo.getId(), 6);
        assertEquals(ResponsePojo.getName(), "welcome you all");
        assertEquals(ResponsePojo.getContent(), " Welcome  tosin {firstname} {LastName}");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure `User is not able to get SMS Template Using an Invalid ID")
    @Story("Get SMS Template Using invalid ID")
    public void Get_SMS_Template_Using_invalid_ID() throws InterruptedException, IOException {
        Response response = GET_200(Get_sms_template_Invalid_ID_EndPoint);
        response.prettyPeek().then().spec(responseSpec_404);
        Get_SMS_Template_Invalid_ID_Pojo ResponsePojo = response.prettyPeek().then().spec(responseSpec_404)
                .extract()
                .as(Get_SMS_Template_Invalid_ID_Pojo.class);

        assertEquals(ResponsePojo.getStatus(), 404);
        assertEquals(ResponsePojo.getMessage(), "BASIC_TEMPLATE not found with the value : 600");

    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure `Unauthorized `User cant Get Template by ID")
    @Story("Unauthorized user should not be able to access SMS Template using valid Template ID")
    public void Get_SMS_Template_Unauthorized_User() throws InterruptedException, IOException {
        Response response = GET_401(Get_sms_template_Invalid_ID_EndPoint);
        response.prettyPeek().then().spec(responseSpec_403);
    }
}
