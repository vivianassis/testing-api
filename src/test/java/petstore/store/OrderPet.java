package petstore.store;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class OrderPet extends BaseStore {
    //Cria o método
    @Test
    public static void placeOrder() {
        //Adiciona o gherkin
        given()// - O que a requisição pede (headers, body)
            .contentType(ContentType.JSON)
            .body(orderBody)
        .when() // - Método usado (GET,POST...)
            .post(uri + "/store/order")
        .then()  // - Validação (status code, body...)
            .assertThat()
            .statusCode(200)
            .assertThat()
            .body("complete", equalTo(true))  // - 1º tipo de validação
            .log().all()
            .assertThat()
            .body("status",is("placed"))  // - Outro tipo de validação
        ;
    }
}