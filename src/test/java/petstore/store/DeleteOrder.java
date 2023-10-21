package petstore.store;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import static petstore.store.OrderPet.placeOrder;

public class DeleteOrder extends BaseStore{
    @Test
    public void deleteOrder(){
        placeOrder();
        given()
                .contentType(ContentType.JSON)
                .header("api_key", token)
                .log().all()
        .when()
                .delete(uri + "/store/order/"+ orderId)
        .then()
                .assertThat()
                .statusCode(200)
                .assertThat()
                .body("message", is(String.valueOf(orderId)))
                .log().all()
        ;
    }
}
