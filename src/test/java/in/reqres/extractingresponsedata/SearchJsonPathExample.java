package in.reqres.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;

import static io.restassured.RestAssured.given;


public class SearchJsonPathExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://reqres.in";
        response = given()
                .when()
                .get("/api/users")
                .then().statusCode(200);

    }


    // 1) Get .page = 2
    @Test
    public void test001() {
        int page = response.extract().path("page");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Page number is : " + page);
        System.out.println("------------------End of Test---------------------------");

    }

    // 2)  Get .per_page = 6
    @Test
    public void test002() {
        int page = response.extract().path("per_page");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Per page user is  : " + page);
        System.out.println("------------------End of Test---------------------------");

    }

    // 3)  Get data[1].id = 8
    @Test
    public void test003() {
        int id = response.extract().path("data[1].id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The user id is : " + id);
        System.out.println("------------------End of Test---------------------------");
    }

    // 4) Get .data[3].first_name = Eve
    @Test
    public void test004() {
        String name = response.extract().path("data[3].first_name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first name is  : " + name);
        System.out.println("------------------End of Test---------------------------");

    }

    // 5) Get list of data = 6
    @Test
    public void test005() {
        List<Integer> listOfData = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The list of the data is : " + listOfData.size());
        System.out.println("------------------End of Test---------------------------");
    }

    // 6) Get data[5].avatar="https://reqres.in/img/faces/11-image.jpg
    @Test
    public void test006() {
        String avatar = response.extract().path("data[5].avatar");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The avatar is : "+avatar);
        System.out.println("------------------End of Test---------------------------");
    }

    // 7) Get support.url ="https://reqres.in/#support-heading"
    @Test
    public void test007() {
        String url = response.extract().path("support.url");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The  support url is : " + url);
        System.out.println("------------------End of Test---------------------------");
    }

    // 8) Get support.txt = "To keep ReqRes free, contributions towards server costs are appreciated!"
    @Test
    public void test008() {
        String txt = response.extract().path("support.text");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The support text is : " + txt);
        System.out.println("------------------End of Test---------------------------");
    }
}
