package Telemedicine_Enrollee_MS;
import Base.TestBase;
import Response.Add_Favourite_Pharmacy.Add_Favourite_Pharmacy_Response_Pojo;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertNotNull;
import static pojo.Constant.Constant.Add_favourite_Pharmacy_Endpoint;
import static pojo.PayloadManager.Add_Favourite_Pharmacy_Payload;
import static utility.RestCalls.POST_201;

public class Add_favourite_Pharmacy_POST extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure that a new Pharmacy can be created")
    @Story("Ability to create new pharmacy, pharmacy should appear in the list of pharmacies")
    public void Add_Favourite_Pharmacy_Template() throws InterruptedException, IOException {
        Response response = POST_201(Add_favourite_Pharmacy_Endpoint, Add_Favourite_Pharmacy_Payload());

        Add_Favourite_Pharmacy_Response_Pojo ResponsePojo = response.prettyPeek().then().spec(responseSpec_201)
                .extract()
                .as(Add_Favourite_Pharmacy_Response_Pojo.class);

        //assertEquals(ResponsePojo.getStatus(), 201);
        //assertEquals(ResponsePojo.getMessage(), "Basic template created successfully");
       // assertTrue(isNumeric(ResponsePojo.getData().getId().toString()));
       // assertNotNull(ResponsePojo.getData().getName());
        //assertNotNull(ResponsePojo.getData().getContent());
    }





}
