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

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static pojo.Constant.Constant.Send_SMS_Template_EndPoint;
import static utility.RestCalls.POST_201;
import static utility.Utility.generateStringFromResource;
import static utility.Utility.isNumeric;

public class Send_Dynamic_SMS extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure Signed In User is able to Send Dynamic SMS Messages to a single User")
    @Story("Ensure Signed In User is able to Send Dynamic SMS Messages to a single User")
    public void Send_Dynamic_SMS_Template_Single_Number() throws InterruptedException, IOException {
        Response response = POST_201(Send_SMS_Template_EndPoint, generateStringFromResource("./src/main/java/Payload/Dynamic_SMS_Single.json"));
        response.prettyPeek().then().spec(responseSpec_200);
        SMSTemplatePojo ResponsePojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(SMSTemplatePojo.class);

        assertEquals(ResponsePojo.getStatus(), 200);
        assertEquals(ResponsePojo.getMessage(), "Notification successfully send");
        assertTrue("Population is not a number", isNumeric(String.valueOf(ResponsePojo.getData().getId())));
        assertEquals(ResponsePojo.getData().getFrom(), "baamtu");
        assertEquals(ResponsePojo.getData().getMedia(), "SMS");
        assertEquals(ResponsePojo.getData().getPriority(), "LOW");
        assertFalse(ResponsePojo.getData().getHasAttachment());
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure Signed In User is able to Send Dynamic SMS Messages to a Multiple Users")
    @Story("Ensure Signed In User is able to Send Dynamic SMS Messages to a Multiple Users")
    public void Send_Dynamic_SMS_Multiple_Numbers() throws InterruptedException, IOException {
        Response response = POST_201(Send_SMS_Template_EndPoint, generateStringFromResource("./src/main/java/Payload/Send_Dynamic_SMS_Multiple_Numbers.json"));
        response.prettyPeek().then().spec(responseSpec_200);
        SMSTemplatePojo ResponsePojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(SMSTemplatePojo.class);

        assertEquals(ResponsePojo.getStatus(), 200);
        assertEquals(ResponsePojo.getMessage(), "Notification successfully send");
        assertTrue("Population is not a number", isNumeric(String.valueOf(ResponsePojo.getData().getId())));
        assertEquals(ResponsePojo.getData().getFrom(), "baamtu");
        assertEquals(ResponsePojo.getData().getMedia(), "SMS");
        assertEquals(ResponsePojo.getData().getPriority(), "LOW");
        assertFalse(ResponsePojo.getData().getHasAttachment());
    }
}
