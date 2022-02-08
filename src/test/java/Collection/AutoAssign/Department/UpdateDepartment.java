package Collection.AutoAssign.Department;

import Base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.UpdateDepartmentt;
import static pojo.Constant.Constant.UpdateDepartmenttt;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_404;
import static utility.Utility.generateStringFromResource;


public class UpdateDepartment extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update team 200")
    @Story("An Endpoint to Update Team 200")
    public void UpdateDepartment_200() throws InterruptedException, IOException {
        Response response = PUT_200(UpdateDepartmentt, generateStringFromResource("./src/main/java/Payload/UpdateDepartment.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update issue type 401")
    @Story("An Endpoint to Update issue type 401")
    public void UpdateDepartment_401() throws InterruptedException, IOException {
        Response response = POST_401(UpdateDepartmentt, generateStringFromResource("./src/main/java/Payload/UpdateDepartment.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update issue type 403")
    @Story("An Endpoint to Update issue type 403")
    public void UpdateDepartment_403() throws InterruptedException, IOException {
        Response response = PUT_403(UpdateDepartmentt, generateStringFromResource("./src/main/java/Payload/UpdateDepartment.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update issue type 403")
    @Story("An Endpoint to Update issue type 403")
    public void UpdateDepartment_404() throws InterruptedException, IOException {
        Response response = PUT_200(UpdateDepartmenttt, generateStringFromResource("./src/main/java/Payload/UpdateDepartment.json"));
        Assertions.assertEquals(response.prettyPeek().getStatusCode(), RESPONSE_STATUS_CODE_404);
    }
}
