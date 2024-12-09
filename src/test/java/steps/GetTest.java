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

public class GetTest extends TestBase {
    Constants constants = new Constants();  // Obtém as constantes (como a URL base)
    private Response response;

    @Dado("que a API Image está acessível")
    public void que_a_api_image_está_acessível() {
        RestAssured.baseURI = constants.baseurl;
    }
    @Quando("eu realizo uma request GET para o endpoint {string}")
    public void eu_realizo_uma_request_get_para_o_endpoint(String endpoint) {
        response = given()
                .when()
                .get(endpoint)  // Realiza a requisição GET
                .then()
                .extract()
                .response();
    }
    @Então("o status da resposta deve ser {int}")
    public void o_status_da_resposta_deve_ser(Integer statusCodeEsperado) {
        assertEquals((int) statusCodeEsperado, response.getStatusCode());
    }
    @Então("a resposta deve estar no formato JSON")
    public void a_resposta_deve_estar_no_formato_json() {
        response.then().assertThat().contentType("application/json");
    }

}

