#language: pt

Funcionalidade: Listar imagens de uma raça específica
  Como um usuário da API
  Eu quero obter uma lista de imagens de uma raça específica
  Para que eu possa visualizar as imagens dessa raça disponível no sistema

  Contexto:
    Dado que a API listar raças está acessível

  # CT01 - Validar resposta de sucesso (200 OK)
  Cenario: Obter a lista de imagens de uma raça válida
    Quando eu realizo uma request GET para o endpoint "/breed/beagle/images"
    Então o status da resposta deve ser 200
    E a resposta do corpo deve estar no formato JSON

  # CT02 - Validar estrutura e formato de Dados (200 OK)
  Cenario: Verificar a estrutura da resposta e formato JSON
    Quando eu realizo uma request GET para o endpoint "/breed/beagle/images"
    Então o status da resposta deve ser 200
    E a resposta do corpo deve estar no formato JSON

  # CT03 - Recurso Não Encontrado para breed inválido (404)
  Cenario: Solicitar um recurso que não existe (breed inválido)
    Quando eu realizo uma request GET para o endpoint "/breed/teste/images"
    Então a resposta deve ter o status code 404 para breed inválido

  # CT04 - Validar resposta para um breed com caracteres especiais (404)
  Cenario: Solicitar uma raça com caracteres especiais no nome
    Quando eu realizo uma request GET para o endpoint "/breed/labrador-retriever/images"
    Então a resposta deve ter o status code 404 para breed com caracteres especiais

  # CT05 - Validar resposta para um breed com valor numérico inválido (404)
  Cenario: Solicitar uma raça com valor numérico inválido
    Quando eu realizo uma request GET para o endpoint "/breed/123/images"
    Então a resposta deve ter o status code 404 para breed com valor numérico inválido
