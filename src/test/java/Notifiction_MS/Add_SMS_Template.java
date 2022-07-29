package Notifiction_MS;

import Base.TestBase;
import Response.Add_SMS_Response.Add_SMS_Response_Pojo;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.*;
import static pojo.Constant.Constant.add_sms_template_EndPoint;
import static pojo.PayloadManager.Add_SMS_Template_Payload;
import static utility.RestCalls.POST_201;
import static utility.RestCalls.POST_401;
import static utility.Utility.generateStringFromResource;
import static utility.Utility.isNumeric;

public class Add_SMS_Template extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure that a new SMS template can be added")
    @Story("Ability to add a unique SMS Template")
    public void Add_New_SMS_Template_201() throws InterruptedException, IOException {
        Response response = POST_201(add_sms_template_EndPoint, Add_SMS_Template_Payload());

        Add_SMS_Response_Pojo ResponsePojo = response.prettyPeek().then().spec(responseSpec_201)
                .extract()
                .as(Add_SMS_Response_Pojo.class);

        assertEquals(ResponsePojo.getStatus(), 201);
        assertEquals(ResponsePojo.getMessage(), "Basic template created successfully");
        assertTrue(isNumeric(ResponsePojo.getData().getId().toString()));
        assertNotNull(ResponsePojo.getData().getName());
        assertNotNull(ResponsePojo.getData().getContent());
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure that a duplicate Template cant be added")
    @Story("Ability to add a unique SMS Template")
    public void Add_New_SMS_Template_409() throws InterruptedException, IOException {
        Response response = POST_201(add_sms_template_EndPoint, generateStringFromResource("./src/main/java/Payload/Existing_sms_Template.json"));
        response.prettyPeek().then().spec(responseSpec_409);

        response.then().assertThat().body("status", is(409));
        response.then().assertThat().body("message", is("Template Treeflex already exist"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure that Content cannot be null when Creating SMS Template")
    @Story("Ensure that Content cannot be null when Creating SMS Template")
    public void Add_New_SMS_Template_without_Content() throws InterruptedException, IOException {
        Response response = POST_201(add_sms_template_EndPoint, generateStringFromResource("./src/main/java/Payload/SMS_TemplatewithoutContent.json"));
        response.prettyPeek().then().spec(responseSpec_400);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure that name cannot be null when Creating SMS Template")
    @Story("Ensure that name cannot be null when Creating SMS Template")
    public void Add_New_SMS_Template_without_Name() throws InterruptedException, IOException {
        Response response = POST_201(add_sms_template_EndPoint, generateStringFromResource("./src/main/java/Payload/SMS_TemplatewithoutName.json"));
        response.prettyPeek().then().spec(responseSpec_400);
    }


    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure that name cannot be null when Creating SMS Template")
    @Story("Ensure that name cannot be null when Creating SMS Template")
    public void Add_New_SMS_Template_Invalid_Authorization() throws InterruptedException, IOException {
        Response response = POST_401(add_sms_template_EndPoint, generateStringFromResource("./src/main/java/Payload/SMS_TemplatewithoutName.json"));
        response.prettyPeek().then().spec(responseSpec_403);
    }
}
