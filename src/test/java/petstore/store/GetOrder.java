package petstore.store;

import com.sun.istack.NotNull;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static petstore.store.OrderPet.placeOrder;


public class GetOrder extends BaseStore{
    @Test
    public void GetOrderById(){
        placeOrder();
            //Adiciona o gherkin
            given()// - O que a requisição pede (header, body)
                .contentType(ContentType.JSON)
            .when() // - Método usado (GET,POST...)
                .get(uri + "/store/order/" +orderId)
            .then()  // - Validação (status code, body...)
                .assertThat()
                .statusCode(200)
                .assertThat()
                .body("id",is(orderId))  // - 1º tipo de validação
                /*.assertThat()
                ("id", equalTo(orderId)) - Outro tipo de validação*/
            ;
    }

    @Test
    public void getInventory(){
        given()
                .contentType(ContentType.JSON)
        .when()
                .get(uri+ "/store/inventory")
        .then()
                .assertThat()
                .statusCode(200)
                .assertThat()
                .body("string", not(emptyString()))
                .log().all()
        ;
    }
}
