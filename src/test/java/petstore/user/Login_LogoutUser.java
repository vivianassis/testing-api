package petstore.user;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Login_LogoutUser extends BaseUser{
    @Test
    public void LoginUser(){
        given()
            .contentType(ContentType.JSON)
            .param("username",user)
            .param("password", password)
        .when()
            .get(uri +"/user/login")
        .then()
            .assertThat()
            .statusCode(200)
            .assertThat()
            .body("message", containsString("logged in user session:"))
        ;
    }

    @Test
    public void LogoutUser(){
        given()
            .contentType(ContentType.JSON)
        .when()
            .get(uri + "/user/logout")
        .then()
            .assertThat()
            .statusCode(200)
            .assertThat()
            .body("message", equalTo("ok"))
        ;
    }
}
