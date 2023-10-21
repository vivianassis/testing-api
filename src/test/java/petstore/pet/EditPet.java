package petstore.pet;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;


import java.io.IOException;

import static io.restassured.RestAssured.given;

public class EditPet extends BasePet {

    //editAnimal = [PUT] Atualizar um animal existente
    @Test
    public void editPet() throws IOException {
        AddPet.addPet();

        //Rest Assured seguindo o padrão Gherkin de escrita
        given()
            .contentType(ContentType.JSON)
            .body(jsonBody2)
        .when()
            .put(uri+"/pet")
        .then()
            .statusCode(200)
            .log().all();
}

    @Test
    public static void editPetFromData() throws IOException {
        AddPet.addPet();

        String name = "Doguinho";
        String status = "sold";

        // Rest Assured seguindo o padrão Gherkin de escrita
        given()
            .formParam("petId", petId)
            .formParam("name", name)
            .formParam("status", status)
        .when()
            .post(uri + "/pet/" + petId)
        .then()
            .log().all()
            .statusCode(200);
        System.out.println("Id usado na execução: " + petId);
    }
}
