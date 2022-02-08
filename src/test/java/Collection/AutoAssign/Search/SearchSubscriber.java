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
import static pojo.Constant.Constant.SearchSubscriberr;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;

public class SearchSubscriber extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Search Subscriber 200")
    @Story("An Endpoint to Search Subscriber 200")
    public void SearchSubscriber_200() throws InterruptedException, IOException {
        Response response = GET_200(SearchSubscriberr);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Search Subscriber 401")
    @Story("An Endpoint to Search Subscriber 401")
    public void SearchSubscriber_401() throws InterruptedException, IOException {
        Response response = GET_401(SearchSubscriberr);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Search Subscriber 403")
    @Story("An Endpoint to Get Search Subscriber 403")
    public void SearchSubscriber_403() throws InterruptedException, IOException {
        Response response = GET_403(SearchSubscriberr);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
