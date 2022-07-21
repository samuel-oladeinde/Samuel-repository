package Notifiction_MS;

import Base.TestBase;
import Response.GetUserEnrolled.Data;
import Response.GetUserEnrolled.Datum;
import Response.GetUserEnrolled.GetUserResponse;
import Response.Get_All_SMS_Template.Get_All_SMS_Template_Response;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.ExcelReader;

import java.io.IOException;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.junit.Assert.assertTrue;
import static pojo.Constant.Constant.Get_All_sms_template_EndPoint;
import static utility.RestCalls.*;

public class Get_all_SMS_Template extends TestBase {

    @DataProvider(name = "data-set")
    public static Object[][] DataSet() throws Exception {
        ExcelReader excel = new ExcelReader();
        excel.setExcelFile("./Config/testData.xlsx", "i");
        Object[][] obj = excel.to2DArray();
        return obj;
    }

    @Test(dataProvider = "data-set", priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get User By Latest Message not Enrolled 200")
    @Story("An Endpoint to Get User By Latest Message not Enrolled 200")
    public void GetUser_By_Latest_Message_Not_Enrolled_200(String i) throws InterruptedException, IOException {
        Response response = GET_200(Get_All_sms_template_EndPoint);
        response.prettyPeek().then().spec(responseSpec_200);
        response.then().assertThat().body("id[" + i + "]", is(5));
        //response.then().assertThat().body("content[0]", is(59));
       // response.then().assertThat().body("name[0]", is(59));
    }
}
