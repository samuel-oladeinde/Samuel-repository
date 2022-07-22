package Notifiction_MS;

import Base.TestBase;
import Response.Send_SMS_Single_User_Response.SMSTemplatePojo;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static pojo.Constant.Constant.Send_SMS_Template_EndPoint;
import static utility.RestCalls.POST_201;
import static utility.RestCalls.POST_401;
import static utility.Utility.generateStringFromResource;
import static utility.Utility.isNumeric;

public class Send_Static_SMS_Message extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure Signed In User is able to Send SMS Messages to a single User")
    @Story("Ensure Signed In User is able to Send SMS Messages to a single User")
    public void Send_SMS_Template_Single_Number() throws InterruptedException, IOException {
        Response response = POST_201(Send_SMS_Template_EndPoint, generateStringFromResource("./src/main/java/Payload/Single_User_SMS.json"));
        response.prettyPeek().then().spec(responseSpec_200);
        SMSTemplatePojo ResponsePojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(SMSTemplatePojo.class);

        assertEquals(ResponsePojo.getStatus(), 200);
        assertEquals(ResponsePojo.getMessage(), "Notification successfully send");
        assertTrue("Population is not a number", isNumeric(String.valueOf(ResponsePojo.getData().getId())));
        assertEquals(ResponsePojo.getData().getFrom(), "baamtu");
        assertEquals(ResponsePojo.getData().getMedia(), "SMS");
        assertEquals(ResponsePojo.getData().getPriority(), "MEDIUM");
        assertFalse(ResponsePojo.getData().getHasAttachment());
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure Signed In User is able to Send SMS Messages to a Multiple Users")
    @Story("Ensure Signed In User is able to Send SMS Messages to a Multiple Users")
    public void Send_SMS_Template_Multiple_Numbers() throws InterruptedException, IOException {
        Response response = POST_201(Send_SMS_Template_EndPoint, generateStringFromResource("./src/main/java/Payload/Multiple_SMS_Numbers.json"));
        response.prettyPeek().then().spec(responseSpec_200);
        SMSTemplatePojo ResponsePojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(SMSTemplatePojo.class);

        assertEquals(ResponsePojo.getStatus(), 200);
        assertEquals(ResponsePojo.getMessage(), "Notification successfully send");
        assertTrue("Population is not a number", isNumeric(String.valueOf(ResponsePojo.getData().getId())));
        assertEquals(ResponsePojo.getData().getFrom(), "baamtu");
        assertEquals(ResponsePojo.getData().getMedia(), "SMS");
        assertEquals(ResponsePojo.getData().getPriority(), "MEDIUM");
        assertFalse(ResponsePojo.getData().getHasAttachment());
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure Unauthorized users are not able to send SMS")
    @Story("An unauthorized user should not be able to send sms")
    public void Send_SMS_Ubauthorized_User() throws InterruptedException, IOException {
        Response response = POST_401(Send_SMS_Template_EndPoint, generateStringFromResource("./src/main/java/Payload/Multiple_SMS_Numbers.json"));
        response.prettyPeek().then().spec(responseSpec_403);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure Signed In User is able to Send SMS Messages to a Multiple Users")
    @Story("Ensure Signed In User is able to Send SMS Messages to a Multiple Users")
    public void Send_SMS_Template_with_Incomplete_Payload() throws InterruptedException, IOException {
        Response response = POST_201(Send_SMS_Template_EndPoint, generateStringFromResource("./src/main/java/Payload/Send_SMS_Message_Incomplete_Payload.json"));
        response.prettyPeek().then().spec(responseSpec_400).assertThat().
                body("status", is(400)).
                body("message", is("unable to process the contained instructions"));
    }
}
