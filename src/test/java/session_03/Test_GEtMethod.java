package session_03;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_GEtMethod {
    @Test
    public void test01() {
        Response res = get("https://reqres.in/api/users?page=2");
        System.out.println("Responsecode" + " " + res.getStatusCode());
        System.out.println("Response body " + " " + res.getBody().asString());
        System.out.println("Response Time " + " " + res.getTime());
        System.out.println("Response Header " + " " + res.getHeader("Content-Type"));

        //validate status code
        //Expected status code - 200;
        int expected_status = 200;
        int Actual_code = res.statusCode();

        Assert.assertEquals(expected_status,Actual_code);
    }
    @Test
    public void TestFail(){
        Response res = get("https://reqres.in/api/users?page=2");

        int expected_status = 201;
        int Actual_code = res.statusCode();

        Assert.assertEquals(expected_status,Actual_code);
    }
    @Test
    public void Test02(){

        //Given, when , then;
        baseURI="https://reqres.in/api/users";
        given()
                .queryParam("page", "2")
                .when().get().then()
                .statusCode(200);


    }
}
