package in.reqres.userinfo;

import in.reqres.model.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserPostTest extends TestBase {

    @Test
    public void createUser() {

        UserPojo userPojo = new UserPojo();
        userPojo.setName("morpheus");
        userPojo.setJob("leader");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
    public void userLoginSuccessfull() {
        UserPojo userPojo1 = new UserPojo();
        userPojo1.setEmail("eve.holt@reqres.in");
        userPojo1.setPassword("cityslicka");

        Response response=given()
                .body(userPojo1)
                .when()
                .post("/login");
        response.then().statusCode(200);
        response.prettyPrint();




    }


}
