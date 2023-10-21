package petstore.pet;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;


public class AddPet extends BasePet {
    public static String addPet;

    //addAnimal = [POST] Adicionar animal
    //Rest Assured seguindo o padrão Gherkin de escrita
    @Test
    public static void addPet() throws IOException {

        given()
            .contentType(ContentType.JSON) //Apresenta no Swagger e é mais comum em API REST - Mais antigas usam o tipo 'text/xml'
            .body(jsonBody)
        .when()
            .post(uri + "/pet")
        .then()
            .log().all()
            .statusCode(200);

        System.out.println("Id gerado para a execução: " + petId);
    }


    //addImagem = [POST] upload de foto do animal
    @Test(dependsOnMethods = "addPet")
    public void uploadImageToPet() throws IOException {
        String additionalMetadata = "";

        given()
                .multiPart("petId", petId)
                .multiPart("additionalMetadata", additionalMetadata)
                .multiPart("file", new File(filePath))
                .log().all()
                .when()
                .post(uri + "/pet/" + petId + "/uploadImage")
                .then()
                .log().all()
                .statusCode(200);
        System.out.println("Id usado na execução: " + petId);
    }

}
