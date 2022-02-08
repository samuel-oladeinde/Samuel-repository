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
import static pojo.Constant.Constant.*;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;

public class ListDepartment extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to List Department 200")
    @Story("An Endpoint to List Department 200")
    public void ListDepartment_200() throws InterruptedException, IOException {
        Response response = GET_200(ListDepartmentt);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to List Department 401")
    @Story("An Endpoint to List Department 401")
    public void ListDepartment_401() throws InterruptedException, IOException {
        Response response = GET_401(ListDepartmentt);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to List Department 403")
    @Story("An Endpoint to List Department 403")
    public void ListDepartment_403() throws InterruptedException, IOException {
        Response response = GET_403(ListDepartmentt);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

}
