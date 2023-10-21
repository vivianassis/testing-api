package petstore.user;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CreateUser extends BaseUser{
    @Test
    public static void createUser(){
        given()
            .contentType(ContentType.JSON)
                .body(jsonBody)
        .when()
            .post(uri + "/user")
        .then()
                .assertThat()
                .statusCode(200)
                .assertThat()
                .body("message", is(String.valueOf(userId)))
                .log().body()

        ;
    }
}
