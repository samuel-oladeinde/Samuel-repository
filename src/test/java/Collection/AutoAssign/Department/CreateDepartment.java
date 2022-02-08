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
import static pojo.Constant.Constant.CreateDepartmentt;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;
import static utility.Utility.generateStringFromResource;

public class CreateDepartment extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Department 200")
    @Story("An Endpoint to Create Department 200")
    public void CreateDepartment_200() throws InterruptedException, IOException {
        Response response = POST_200(CreateDepartmentt, generateStringFromResource("./src/main/java/Payload/CreateDepartmentPayload.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint Create Department 401")
    @Story("An Endpoint to Create Department 401")
    public void CreateDepartment_401() throws InterruptedException, IOException {
        Response response = POST_401(CreateDepartmentt, generateStringFromResource("./src/main/java/Payload/CreateDepartmentPayload.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Department 403")
    @Story("An Endpoint to Create Department 403")
    public void CreateDepartment_403() throws InterruptedException, IOException {
        Response response = POST_403(CreateDepartmentt, generateStringFromResource("./src/main/java/Payload/CreateDepartmentPayload.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
