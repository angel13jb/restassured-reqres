package in.reqres.userinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserDeleteTest extends TestBase {

    @Test
    public void deleteUser(){
        Response response=given()
                .when()
                .delete("/users/3");
        response.then().statusCode(204);
        response.prettyPrint();
    }
}
