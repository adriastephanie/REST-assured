import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://dog.ceo/api"; // URL de exemplo
    }

    @Test
    public void testGetListAll() {
        // Requisição GET
        given()
                .when()
                .get("/breeds/list/all") // Endpoint
                .then()
                .statusCode(200);  // Verificando que o código de status da resposta é 200
    }

}
