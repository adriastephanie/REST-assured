package steps;

import Utils.TestBase;
import constants.Constants;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetBreedImageRandom extends TestBase {
    Constants constants = new Constants();  // Obtém as constantes (como a URL base)
    private Response response;

    @Dado("que a API Image Random está acessível")
    public void que_a_api_image_random_está_acessível() {
        RestAssured.baseURI = constants.baseurl;
    }
    @Quando("eu realizo uma busca no GET para o endpoint {string}")
    public void eu_realizo_uma_busca_no_get_para_o_endpoint(String endpoint) {
        response = given()
                .when()
                .get(endpoint)  // Realiza a requisição GET
                .then()
                .extract()
                .response();
    }
    @Então("eu devo receber status code {int}")
    public void eu_devo_receber_status_code(Integer statusCodeEsperado) {
        assertEquals((int) statusCodeEsperado, response.getStatusCode());
    }
    @Então("devo ter como resposta o formato JSON")
    public void devo_ter_como_resposta_o_formato_json() {
        // Write code here that turns the phrase above into concrete actions
        response.then().assertThat().contentType("application/json");
    }
}
