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

    // CT01 - Validar com sucesso a api /breeds/list/all
    @Test
    public void testGetListAllSuccess() {
        // Requisição GET
        given()
                .when()
                .get("/breeds/list/all") // Endpoint
                .then()
                .statusCode(200);
    }
    // CT02 - Validar estrutura e formato de Dados (200 OK)
    @Test
    public void testGetListAllResponseFormat() {
        // Requisição GET para "/breeds/list/all"
        given()
                .when()
                .get("/breeds/list/all")
                .then()
                .statusCode(200)
                .contentType("application/json");  // Verifica se o formato de resposta é JSON
    }
    // CT03 e CT04 - Recurso Não Encontrado (404) com Formato de resposta inválido (404)
    @Test
    public void testGetNonExistentBreed() {
        // Exemplos de raças que não existem
        String[] invalidBreeds = { "beagle", "1111111", "xyzxyz", "abcd1234" };

        for (String breed : invalidBreeds) {
            given()
                    .when()
                    .get("/breeds/list/" + breed)
                    .then()
                    .statusCode(404);  // Verifica se o código de status é 404 (Not Found)
        }
    }
}
