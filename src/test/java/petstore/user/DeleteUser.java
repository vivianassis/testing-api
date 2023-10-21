package petstore.user;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static petstore.user.CreateUser.createUser;

public class DeleteUser extends BaseUser{
    @Test
    public void DeleteUser(){
        createUser();
        given()
                .contentType(ContentType.JSON)
                .header("api_key", token)
                .param("username", user)

        .when()
                .delete(uri + "/user/" + user)
        .then()
                .log().body()
                .assertThat()
                .statusCode(200)
                .body("message", is(user))
                .log().all()
        ;
    }
}
