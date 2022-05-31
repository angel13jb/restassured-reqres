package in.reqres.userinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserGetTest extends TestBase {

    @Test
    public void getAllUsersInfo(){
        Response response =given()
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getSingleUserInfo(){
        Response response=given()
                .when()
                .get("/users/6");
        response.then().statusCode(200);
        response.prettyPrint();

    }









}
