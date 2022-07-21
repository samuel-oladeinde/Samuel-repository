package utility;

import Base.TestBase;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static pojo.PayloadManager.*;
import static utility.Utility.fetchvalue;

public class RestCalls extends TestBase {

	public static int RESPONSE_STATUS_CODE_200 = 200;
	public static int RESPONSE_STATUS_CODE_500 = 500;
	public static int RESPONSE_STATUS_CODE_400 = 400;
	public static int RESPONSE_STATUS_CODE_409 = 409;
	public static int RESPONSE_STATUS_CODE_401 = 401;
	public static int RESPONSE_STATUS_CODE_403 = 403;
	public static int RESPONSE_STATUS_CODE_404 = 404;
	public static int RESPONSE_STATUS_CODE_201 = 201;
	public static String StatusLine_200= "HTTP/1.1 200 OK";
	public static String StatusLine_201= "HTTP/1.1 201 Created";
	public static String StatusLine_400= "HTTP/1.1 400 Bad Request";
	public static String StatusLine_404= "HTTP/1.1 404 Not Found";
	public static String StatusLine_403= "HTTP/1.1 403 Forbidden";
	public static String StatusLine_409= "HTTP/1.1 409 Conflict";


	static RequestLoggingFilter PayloadLog = new RequestLoggingFilter();
	static RequestLoggingFilter ResponseBodyLog = new RequestLoggingFilter();

	public static Response GET_200(String uRI) throws InterruptedException {
		return RestAssured.given().headers(
				"Authorization", "Bearer "+ GetAuthToken(),
				"Content-Type",
				ContentType.JSON).when().get(uRI);
	}

	public static Response GET_404(String uRI) throws InterruptedException {
		return RestAssured.given().filter(PayloadLog).filter(ResponseBodyLog)
				.filter(new AllureRestAssured()).headers(
				"token", GetAuthToken(),
				"Content-Type",
				ContentType.JSON).when().get(uRI);
	}

	public static Response GET_403(String uRI) throws InterruptedException {
		return RestAssured.given().filter(PayloadLog).filter(ResponseBodyLog)
				.filter(new AllureRestAssured()).headers(
				"token", GetAuthToken_403(),
				"Content-Type",
				ContentType.JSON).when().get(uRI);
	}

	public static Response GET_401(String uRI) {
		return RestAssured.given().filter(PayloadLog).filter(ResponseBodyLog)
				.filter(new AllureRestAssured()).headers(
				"Content-Type",
				ContentType.JSON).when().get(uRI);
	}

	public static Response POST_200(String uRI, String Body) throws InterruptedException {
		return RestAssured.given().log().all().headers("Authorization", "Bearer "+ GetAuthToken(),
				"Content-Type",
				ContentType.JSON).when().body(Body).post(uRI);
	}

	public static Response POST_201(String uRI, String Body) throws InterruptedException {
		return RestAssured.given().log().all().headers("Authorization", "Bearer "+ GetAuthToken(),
						"Content-Type",
						ContentType.JSON).when().body(Body).post(uRI);
	}

	public static Response POST_403(String uRI, String Body) throws InterruptedException {
		return RestAssured.given().filter(PayloadLog).filter(ResponseBodyLog)
				.filter(new AllureRestAssured()).filter(PayloadLog).filter(ResponseBodyLog)
				.filter(new AllureRestAssured()).log().all().headers(
				"token", GetAuthToken_403(),
				"Content-Type",
				ContentType.JSON).when().body(Body).post(uRI);
	}

	public static Response POST_AUTH_200(String uRI, String Body) throws InterruptedException {
		return RestAssured.given().headers("Content-Type",
				ContentType.JSON).when().body(Body).post(uRI);
	}

	public static Response GetRequestBody(String uRI, String Body) throws InterruptedException {
		return RestAssured.given().filter(PayloadLog).filter(ResponseBodyLog)
				.filter(new AllureRestAssured()).headers(
				"token", GetAuthToken(),
				"Content-Type",
				ContentType.JSON).when().body(Body).get(uRI);
	}

	public static Response POST_401(String uRI, String Body) {
		return RestAssured.given().filter(PayloadLog).filter(ResponseBodyLog)
				.filter(new AllureRestAssured()).headers(
				"token", "Bad Token",
				"Content-Type",
				ContentType.JSON).when().body(Body).post(uRI);
	}

	public static Response PUT_200(String uRI, String Body) throws InterruptedException {
		return RestAssured.given().log().all().headers("Authorization", "Bearer "+ GetAuthToken(),
				"Content-Type",
				ContentType.JSON).when().body(Body).put(uRI);
	}

	public static Response PUT_403(String uRI, String Body) throws InterruptedException {
		return RestAssured.given().filter(PayloadLog).filter(ResponseBodyLog)
				.filter(new AllureRestAssured()).log().all().headers(
				"token", GetAuthToken_403(),
				"Content-Type",
				ContentType.JSON).when().body(Body).put(uRI);
	}

	public static Response PUT_404(String uRI, String Body) throws InterruptedException {
		return RestAssured.given().headers(
				"token", GetAuthToken(),
				"Content-Type",
				ContentType.JSON).when().body(Body).put(uRI);
	}

	public static Response PUT_400(String uRI, String Body) throws InterruptedException {
		return RestAssured.given().filter(PayloadLog).filter(ResponseBodyLog)
				.filter(new AllureRestAssured()).headers(
				"token", GetAuthToken(),
				"Content-Type",
				ContentType.JSON).when().body(Body).put(uRI);
	}

	public static Response PUT_401(String uRI, String Body) {
		return RestAssured.given().filter(PayloadLog).filter(ResponseBodyLog)
				.filter(new AllureRestAssured()).headers(
				"token","Bad token",
				"Content-Type",
				ContentType.JSON).when().body(Body).put(uRI);
	}

	public static Response DELETE_200(String uRI) throws InterruptedException {
		return RestAssured.given().filter(PayloadLog).filter(ResponseBodyLog)
				.filter(new AllureRestAssured()).log().all().headers(
				"token", GetAuthToken(),
				"Content-Type",
				ContentType.JSON).when().delete(uRI);
	}

	public static Response DELETE_401(String uRI) throws InterruptedException {
		return RestAssured.given().filter(PayloadLog).filter(ResponseBodyLog)
				.filter(new AllureRestAssured()).log().all().headers(
				"token", "bad token",
				"Content-Type",
				ContentType.JSON).when().delete(uRI);
	}

	public static Response DELETE_404(String uRI) throws InterruptedException {
		return RestAssured.given().filter(PayloadLog).filter(ResponseBodyLog)
				.filter(new AllureRestAssured()).log().all().headers(
				"token", GetAuthToken(),
				"Content-Type",
				ContentType.JSON).when().delete(uRI);
	}

	public static Response DELETERequestBody(String uRI, String Body) throws InterruptedException {
		return RestAssured.given().filter(PayloadLog).filter(ResponseBodyLog)
				.filter(new AllureRestAssured()).headers(
				"token", GetAuthToken(),
				"Content-Type",
				ContentType.JSON).when().body(Body).delete(uRI);
	}

	public static String GetAuthToken() throws InterruptedException {
		RestAssured.baseURI = fetchvalue("BaseUrlAuthQa");
		Response response = POST_AUTH_200("", AuthorizationPayload());
		return response.path("access_token").toString();
	}

	public static String GetAuthToken_403() throws InterruptedException {
		RestAssured.baseURI = fetchvalue("BaseUrlAuthQa");
		Response response = POST_AUTH_200("", AuthorizationPayload()).prettyPeek();
		System.out.println(response.getStatusCode());
		Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_403);
		Assertions.assertEquals(response.getStatusLine(), StatusLine_403);
		return "403";
	}

	public static String truncate(String str, int length, String delim) {
		int len = Math.max(0, length);
		if (str.length() <= len) return str;
		else {
			int idx = str.lastIndexOf(delim, len);
			return str.substring(0, idx != -1 ? idx : len);
		}
	}

}
