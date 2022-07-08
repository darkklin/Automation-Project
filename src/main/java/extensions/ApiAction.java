package extensions;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import utilities.CommonOps;

import static io.restassured.RestAssured.given;

public class ApiAction extends CommonOps {

    @Step("Get Date From Server")
    public static Response get(String paramValues) {
        return response = httpRequest.get(paramValues);

    }

    @Step("Extract Value From json Format")
    public static String extractFromJcon(Response response, String path) {
        jp = response.jsonPath();
        return jp.get(path).toString();

    }

    public static Response sendPostRequest(String json, String urlPath) {
        return given().header("Content-Type", "application/json").queryParam("key", "qaclick123")
                .body(json).when().post(urlPath)
                .then().assertThat().statusCode(200).body("status", Matchers.equalTo("OK"))
                .extract().response();


    }
    public static Response sendPostRequest(JSONObject params, String urlPath) {
        httpRequest.body(params.toJSONString());
        return response = httpRequest.post(urlPath);

    }
    public static Response sendPutRequest(JSONObject params, String urlPath) {
        httpRequest.body(params.toJSONString());
        return response = httpRequest.put(urlPath);

    }

}
