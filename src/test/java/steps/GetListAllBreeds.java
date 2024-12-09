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

public class GetListAllBreeds extends TestBase {
    Constants constants = new Constants();  // Obtém as constantes (como a URL base)
    private Response response;

    // CT01 - Validar resposta de sucesso (200 OK)
    @Dado("que a API listar raças está acessível")
    public void que_a_api_listar_raças_está_acessível() {
        // Setup inicial, como configurar a base URL se necessário
        RestAssured.baseURI = constants.baseurl;
    }

    @Quando("eu faço uma requisição GET para o endpoint {string}")
    public void eu_faço_uma_requisicao_get_para_o_endpoint(String endpoint) {
        response = given()
                .when()
                .get(endpoint)  // Realiza a requisição GET
                .then()
                .extract()
                .response();
    }

    @Então("a resposta deve ter o status code {int}")
    public void a_resposta_deve_ter_o_status_code(Integer statusCodeEsperado) {
        // Verifica se o status code da resposta é o esperado
        assertEquals((int) statusCodeEsperado, response.getStatusCode());
    }

    @Então("o corpo da resposta deve estar no formato JSON")
    public void o_corpo_da_resposta_deve_estar_no_formato_json() {
        // Verifica se o corpo da resposta está no formato JSON
        response.then().assertThat().contentType("application/json");
    }

    // CT03 - Recurso Não Encontrado (404)
    @Quando("eu faço uma requisição GET para o endpoint \"/breeds/list/1\"")
    public void eu_faço_uma_requisicao_get_para_um_recurso_inexistente() {
        response = given()
                .when()
                .get("/breeds/list/1")  // Endpoint inválido
                .then()
                .extract()
                .response();
    }

    @Então("a resposta deve ter o status code {int} para recurso inexistente")
    public void a_resposta_deve_ter_o_status_code_para_recurso_inexistente(Integer statusCodeEsperado) {
        // Verifica se o status code é 404 (não encontrado) para o recurso inexistente
        assertEquals((int) statusCodeEsperado, response.getStatusCode());
    }

    // CT04 - Formato de resposta inválido (404)
    @Quando("eu faço uma requisição GET para o endpoint {string} com parâmetros inválidos")
    public void eu_faço_uma_requisicao_get_com_parametros_invalidos(String endpoint) {
        response = given()
                .when()
                .get(endpoint)  // Endpoint com parâmetros inválidos
                .then()
                .extract()
                .response();
    }

    @Então("a resposta deve ter o status code {int} para parâmetros inválidos")
    public void a_resposta_deve_ter_o_status_code_para_parametros_invalidos(Integer statusCodeEsperado) {
        // Verifica se o status code da resposta é 404 (não encontrado) para parâmetros inválidos
        assertEquals((int) statusCodeEsperado, response.getStatusCode());
    }
}
