package Notifiction_MS;

import Base.TestBase;
import Response.Add_SMS_Response.Add_SMS_Response_Pojo;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.Delete_SMS_Template.Delete_SMS_Template_Pojo;

import static org.testng.Assert.*;
import static org.testng.Assert.assertNotNull;
import static pojo.Constant.Constant.Delete_SMS_Template_EndPoint;
import static pojo.Constant.Constant.add_sms_template_EndPoint;
import static pojo.PayloadManager.Add_SMS_Template_Payload;
import static utility.RestCalls.*;
import static utility.Utility.fetchvalue;
import static utility.Utility.isNumeric;

import java.io.IOException;

public class Delete_SMS_Template extends TestBase {


    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure that a user is able to delete SMS Template when a valid SMS Template ID is used")
    @Story("An authenticated user should be able to delete an SMS Template")
    public void Delete_SMS_Template() throws InterruptedException, IOException {
        String k = String.valueOf(Create_New_SMS_Template());
        RestAssured.baseURI = fetchvalue("BaseURL_Messenger");
        Response response = DELETE_200(Delete_SMS_Template_EndPoint + k);
        Delete_SMS_Template_Pojo ResponsePojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(Delete_SMS_Template_Pojo.class);

        assertEquals(ResponsePojo.getStatus(), 200);
        assertNotNull(ResponsePojo.getMessage());
        assertNull(ResponsePojo.getData());
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure that a user is not able to delete SMS Template when an invalid Template ID is used")
    @Story("Ensure that a status code of 404 is returned when deleting SMS Template with an invalid `Template ID")
    public void Delete_SMS_Template_with_Invalid_Template_ID() throws InterruptedException, IOException {
        Response response = DELETE_200(Delete_SMS_Template_EndPoint + "8");

        Delete_SMS_Template_Pojo ResponsePojo = response.prettyPeek().then().spec(responseSpec_404)
                .extract()
                .as(Delete_SMS_Template_Pojo.class);

        assertEquals(ResponsePojo.getStatus(), 404);
        assertNotNull(ResponsePojo.getMessage());
        assertNull(ResponsePojo.getData());
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure an unauthorized user is not able to delete SMS Template")
    @Story("Ensure an unauthorized user is not able to delete SMS Template")
    public void Delete_SMS_Template_Unauthorized_User() throws InterruptedException, IOException {
        Response response = DELETE_401(Delete_SMS_Template_EndPoint + "8");
        Delete_SMS_Template_Pojo ResponsePojo = response.prettyPeek().then().spec(responseSpec_403)
                .extract()
                .as(Delete_SMS_Template_Pojo.class);

        assertEquals(ResponsePojo.getStatus(), 403);
        assertNotNull(ResponsePojo.getMessage());
        assertNull(ResponsePojo.getData());
    }


    public Integer Create_New_SMS_Template() throws InterruptedException, IOException {
        Response response = POST_201(add_sms_template_EndPoint, Add_SMS_Template_Payload());

        Add_SMS_Response_Pojo ResponsePojo = response.prettyPeek().then().spec(responseSpec_201)
                .extract()
                .as(Add_SMS_Response_Pojo.class);

        assertEquals(ResponsePojo.getStatus(), 201);
        assertEquals(ResponsePojo.getMessage(), "Basic template created successfully");
        assertTrue(isNumeric(ResponsePojo.getData().getId().toString()));
        assertNotNull(ResponsePojo.getData().getName());
        assertNotNull(ResponsePojo.getData().getContent());

        return ResponsePojo.getData().getId();
    }
}
