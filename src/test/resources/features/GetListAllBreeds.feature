#language: pt

Funcionalidade: Listar todas as raças

  Como um usuário da API
  Eu quero obter uma lista de todas as raças
  Para que eu possa verificar as raças disponíveis no sistema

  Contexto:
  Dado que a API listar raças está acessível

  # CT01 - Validar resposta de sucesso (200 OK)
  Cenário: Obter a lista de todas as raças
    Quando eu faço uma requisição GET para o endpoint "/breeds/list/all"
    Então a resposta deve ter o status code 200

  # CT02 - Validar estrutura e formato de Dados (200 OK)
  Cenário: Verificar a estrutura da resposta e formato JSON
    Quando eu faço uma requisição GET para o endpoint "/breeds/list/all"
    Então a resposta deve ter o status code 200
    E o corpo da resposta deve estar no formato JSON

  # CT03 - Recurso Não Encontrado (404) unido com o CT04 - Formato de resposta inválido (404)
  Esquema do Cenário: Solicitar um recurso que não existe
    Quando eu faço uma requisição GET para o endpoint "/breeds/list/<breed>"
    Então a resposta deve ter o status code 404
    Exemplos:
      | beagle          |
      | 1111111         |
      | xyzxyz          |
      | abcd1234        |

