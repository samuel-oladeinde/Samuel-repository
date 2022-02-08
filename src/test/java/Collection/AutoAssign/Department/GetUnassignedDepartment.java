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
import static pojo.Constant.Constant.GetUNassignedDepartmentt;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;

public class GetUnassignedDepartment extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Get Unassigned Department 200")
    @Story("An Endpoint to Get Unassigned Department 200")
    public void GetUnassignedDepartment_200() throws InterruptedException, IOException {
        Response response = GET_200(GetUNassignedDepartmentt);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Unassigned Department 401")
    @Story("An Endpoint to Get Unassigned Department 401")
    public void GetUnassignedDepartment_401() throws InterruptedException, IOException {
        Response response = GET_401(GetUNassignedDepartmentt);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Unassigned Department 403")
    @Story("An Endpoint to Get Unassigned Department 403")
    public void GetUnassignedDepartment_403() throws InterruptedException, IOException {
        Response response = GET_403(GetUNassignedDepartmentt);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
