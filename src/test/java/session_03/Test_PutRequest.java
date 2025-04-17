package session_03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_PutRequest {

    @Test
    public void test04(){

        JSONObject jsonData = new JSONObject();
        jsonData.put("name","Krishna");
        jsonData.put("job","Artist");

        RestAssured.baseURI= "https://reqres.in/api/users/680";
        RestAssured.given().header("Content-type", "application/json").contentType(ContentType.JSON).
                body(jsonData.toJSONString())
                .when().put()
                .then().statusCode(200).log().all();

    }
}
