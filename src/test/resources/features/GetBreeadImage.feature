#language: pt

Funcionalidade: Listar imagens de uma raça específica
  Como um usuário da API
  Eu quero obter uma lista de imagens de uma raça específica
  Para que eu possa visualizar as imagens dessa raça disponível no sistema

  # CT01 - Validar resposta de sucesso (200 OK)
  Cenário: Obter a lista de imagens de uma raça válida
    Dado que a API Image está acessível
    Quando eu realizo uma request GET para o endpoint "breed/beagle/images"
    Então o status da resposta deve ser 200

  # CT02 - Validar estrutura
  Cenário: Verificar a estrutura da resposta e formato JSON
    Dado que a API Image está acessível
    Quando eu realizo uma request GET para o endpoint "breed/beagle/images"
    Então o status da resposta deve ser 200
    E a resposta deve estar no formato JSON

  # CT03 - Recurso Não Encontrado (404)
  Esquema do Cenário: Solicitar um recurso que não existe
    Dado que a API Image está acessível
    Quando eu faço uma requisição GET para o endpoint "breed/<breed>/images"
    Então a resposta deve ter o status code 404
    Exemplos:
      | breed           |
      | tetetes         |
      | xyzxyz          |
      | abcd1234        |

  # CT04 - Validar resposta para um breed com caractere especial (404)
  Esquema do Cenário: Solicitar um recurso com caracter especial
    Dado que a API Image está acessível
    Quando eu faço uma requisição GET para o endpoint "breed/<breed>/images"
    Então a resposta deve ter o status code 404
    Exemplos:
      | breed                |
      | abla-dor-retriever   |
      | dog@123              |
      | retriever!special    |

  # CT05 - Validar resposta para um breed com valor numérico (404)
  Esquema do Cenário: Solicitar um recurso com valor numérico
    Dado que a API Image está acessível
    Quando eu faço uma requisição GET para o endpoint "breed/<breed>/images"
    Então a resposta deve ter o status code 404
    Exemplos:
      | breed |
      | 123   |
      | 4567  |
      | 8910  |