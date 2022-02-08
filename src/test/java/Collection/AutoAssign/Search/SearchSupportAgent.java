package Collection.AutoAssign.Search;

import Base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.SearchSupportAgentt;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;

public class SearchSupportAgent extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Search Support Agent 200")
    @Story("An Endpoint to Search Support Agent 200")
    public void SearchSupportAgent_200() throws InterruptedException, IOException {
        Response response = GET_200(SearchSupportAgentt);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Search Support Agent 401")
    @Story("An Endpoint to Search Support Agent 401")
    public void SearchSupportAgent_401() throws InterruptedException, IOException {
        Response response = GET_401(SearchSupportAgentt);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Search Support Agent 403")
    @Story("An Endpoint to Get Search Support Agent 403")
    public void SearchSupportAgent_403() throws InterruptedException, IOException {
        Response response = GET_403(SearchSupportAgentt);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
