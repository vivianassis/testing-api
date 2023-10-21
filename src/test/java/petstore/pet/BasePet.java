package petstore.pet;

import java.util.Random;

public class BasePet {
    static String uri = "https://petstore.swagger.io/v2";
    static String token = "special_key";
    static int petId;
    static int petId2;

    static {
        // Gere o petId apenas uma vez durante a inicialização da classe
        Random random = new Random();
        petId = random.nextInt(100000);
    }

    static {
        // Gere o petId apenas uma vez durante a inicialização da classe
        Random random = new Random();
        petId2 = random.nextInt(100000);
    }

//DATAS--------------------------------------------------------------------------------------------<<<<
    String filePath = "C:\\Users\\vgaldino\\IdeaProjects\\automacao-api\\src\\test\\resources\\database\\cao.png";
    static String jsonBody =
            "{ \"id\": " + petId + ", " +
            "  \"category\": { \"id\": 0, \"name\": \"dog\" }, " +
            "  \"name\": \"Dogzito\", " +
            "  \"photoUrls\": [\"string\"], " +
            "  \"tags\": [ " +
            "{\"id\": 0, \"name\": \"string\" } " +
            "], " +
            "  \"status\": \"available\" }";
    String jsonBody2 =
            "{ \"id\": " + petId2 + ", " +
            "  \"category\": { \"id\": 0, \"name\": \"dog\" }, " +
            "  \"name\": \"Doguinho\", " +
            "  \"photoUrls\": [\"string\"], " +
            "  \"tags\": [ " +
            "{\"id\": 0, \"name\": \"string\" } " +
            "], " +
            "  \"status\": \"sold\" }";
}