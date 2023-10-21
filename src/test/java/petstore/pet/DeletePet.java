package petstore.pet;

import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class DeletePet extends BasePet {


    //deleteAnimal = [DELETE] Exclui animal da loja
    @Test
    public void deletePet() throws IOException {
        AddPet.addPet();

        // Rest Assured seguindo o padrão Gherkin de escrita
        given()
            .header("api_key", token)
            .log().all()
        .when()
            .delete(uri + "/pet/" + petId)
        .then()
            .log().all()
            .assertThat()
            .statusCode(200)
            .assertThat()
            .body("message", is(String.valueOf(petId)));
    }
}
