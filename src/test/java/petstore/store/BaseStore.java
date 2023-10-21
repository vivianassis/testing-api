package petstore.store;


import petstore.BaseClass;

import java.util.Random;

public class BaseStore extends BaseClass {
    static String uri = "https://petstore.swagger.io/v2";
    static String token = "special_key";

    static int petId;
    static int quantifier;
    static int orderId;

    static {
        // Gere o petId apenas uma vez durante a inicialização da classe
        Random random = new Random();
        petId = random.nextInt(10);
        quantifier = random.nextInt(10);
        orderId = random.nextInt(10);
    }

//DATA----------------------------------------------------------------<<
     static String orderBody =
            "{\"id\": " + orderId + ", " +
            "\"petId\": " + petId + ", " +
            "\"quantity\": " + quantifier + ", " +
            "\"shipDate\": \"2023-10-19T12:09:53.943Z\", " +
            "\"status\": \"placed\", " +
            "\"complete\": true}";

}
