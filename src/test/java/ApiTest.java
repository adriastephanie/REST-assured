import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import constants.Constants;

import static io.restassured.RestAssured.given;

public class ApiTest {
    Constants constants;

    @BeforeEach
    void setUp() {
        constants = new Constants(); //
        RestAssured.baseURI = constants.baseurl; // Define a base URL
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
