package session_03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_PostRequest {

    @Test
    public void test04()
    {
        JSONObject jsonData = new JSONObject();
        jsonData.put("name","Unni");
        jsonData.put("job","QA");

        RestAssured.baseURI= "https://reqres.in/api/users";
        RestAssured.given().header("Content-type", "application/json").contentType(ContentType.JSON).
                body(jsonData.toJSONString())
                .when().post()
                        .then().statusCode(201).log().all();


    }


}
