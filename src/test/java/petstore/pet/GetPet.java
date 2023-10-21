package petstore.pet;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetPet extends BasePet {
    // findAnimalByStatus = [GET] Encontra animais por status
    @Test
    public void getByStatusAvaiable() throws IOException {
        String status = "available";
        //Rest Assured seguindo o padrão Gherkin de escrita
        given()
                .contentType("application/json") //Apresenta no Swagger e é mais comum em API REST - Mais antigas usam o tipo 'text/xml'
                .log().all()
                .when()
                .get(uri+"/pet/findByStatus?status=" + status)
                .then()
                .log().all()
                .statusCode(200)
                .body("status", everyItem(equalTo(status)));
    }

    @Test
    public void getByStatusPendent() throws IOException {
        String status = "pending";
        //Rest Assured seguindo o padrão Gherkin de escrita
        given()
                .contentType("application/json") //Apresenta no Swagger e é mais comum em API REST - Mais antigas usam o tipo 'text/xml'
                .log().all()
                .when()
                .get(uri+"/pet/findByStatus?status=" + status)
                .then()
                .log().all()
                .statusCode(200)
                .body("status", everyItem(equalTo(status)));
    }

    @Test
    public void getByStatusSold() throws IOException {
        String status = "sold";
        //Rest Assured seguindo o padrão Gherkin de escrita
        given()
                .contentType("application/json") //Apresenta no Swagger e é mais comum em API REST - Mais antigas usam o tipo 'text/xml'
                .log().all()
                .when()
                .get(uri+"/pet/findByStatus?status=" + status)
                .then()
                .log().all()
                .statusCode(200)
                .body("status", everyItem(equalTo(status)));
    }

    @Test
    public void getById() throws IOException {
        AddPet.addPet();
        //Rest Assured seguindo o padrão Gherkin de escrita
        given()
            .contentType(ContentType.JSON) //Apresenta no Swagger e é mais comum em API REST - Mais antigas usam o tipo 'text/xml'
            .log().all()
        .when()
            .get(uri + "/pet/" + petId)
        .then()
            .log().all()
            .statusCode(200)
            .body("id", equalTo(petId));

        System.out.println("Id usado na execução: " + petId);
    }
}
