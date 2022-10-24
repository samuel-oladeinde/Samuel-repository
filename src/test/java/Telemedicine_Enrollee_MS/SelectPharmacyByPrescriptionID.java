package Telemedicine_Enrollee_MS;

import Base.TestBase;
import Response.Select_Pharmacy_ByPrescriptionID_pojo.Select_Pharmacy_ByPrescriptionID_ResponsePojo;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import static pojo.Constant.Constant.Select_Pharmacy_ByPrescriptionID_Endpoint;
import static pojo.PayloadManager.SelectPharmacyByPrescriptionIDPayload;
import static utility.RestCalls.POST_200;

public class SelectPharmacyByPrescriptionID extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure pharmacy can be selected using Pharmacy ID")
    @Story("Ensure pharmacy can be selected using Pharmacy ID")
    public void Select_Pharmacy_By_Prescription_ID() throws InterruptedException, IOException {
        Response response = POST_200(Select_Pharmacy_ByPrescriptionID_Endpoint, SelectPharmacyByPrescriptionIDPayload());


        Select_Pharmacy_ByPrescriptionID_ResponsePojo responsePojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(Select_Pharmacy_ByPrescriptionID_ResponsePojo.class);

    }
}




