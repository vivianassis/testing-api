package petstore.user;

import java.util.Random;

public class BaseUser {
        static String uri = "https://petstore.swagger.io/v2";
        static String token = "special_key";
        static String user = "vivianassis";
        static String password = "123456";
        static int userId;
        static int userId2;

        static {
            // Gere o petId apenas uma vez durante a inicialização da classe
            Random random = new Random();
            userId = random.nextInt(10);
            userId2 = random.nextInt(10);
        }
    static String jsonBody =
            "{\n" +
            "  \"id\": " + userId + ",\n" +
            "  \"username\": \"vivianassis\",\n" +
            "  \"firstName\": \"string\",\n" +
            "  \"lastName\": \"string\",\n" +
            "  \"email\": \"email_aleatório@email.com\",\n" +
            "  \"password\": " + password + ",\n" +
            "  \"phone\": \"string\",\n" +
            "  \"userStatus\": 0\n" +
            "}";

    String jsonBody2 =
            "{" +
            "  \"id\": " + userId2 + "," +
            "  \"username\": \"vivianassis2\"," +
            "  \"firstName\": \"Viviana2\"," +
            "  \"lastName\": \"Assis2\"," +
            "  \"email\": \"email_aleatório2@email.com\"," +
            "  \"password\": \"123321\"," +
            "  \"phone\": \"string\"," +
            "  \"userStatus\": 1" +
            "}";
    }

