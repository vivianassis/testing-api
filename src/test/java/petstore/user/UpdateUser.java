package petstore.user;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import static petstore.user.CreateUser.createUser;

public class UpdateUser extends BaseUser{
    @Test
    public void updateUser(){
        createUser();
        given()
            .contentType(ContentType.JSON)
            .param("username",user)
            .body(jsonBody2)
        .when()
            .put(uri + "/user/" + user)
        .then()
            .assertThat()
            .statusCode(200)
            .log().body()
            .assertThat()
            .body("message",is(String.valueOf(userId2)))
        ;
    }
}
