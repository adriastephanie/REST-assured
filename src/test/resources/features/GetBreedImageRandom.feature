#language: pt

Funcionalidade: Buscar imagem de uma raça aleatória
  Como um usuário da API
  Eu quero obter uma lista de imagens de uma raça aleatória
  Para que eu possa visualizar as imagens dessa raça disponível no sistema

  # CT01 - Validar resposta de sucesso (200 OK)
  Cenário: Obter imagem uma raça válida
    Dado que a API Image Random está acessível
    Quando eu realizo uma busca no GET para o endpoint "breeds/image/random"
    Então eu devo receber status code 200

    # CT02 - Validar estrutura
  Cenário: Verificar a estrutura da resposta e formato JSON
    Dado que a API Image Random está acessível
    Quando eu realizo uma busca no GET para o endpoint "breeds/image/random"
    Então eu devo receber status code 200
    E devo ter como resposta o formato JSON

    # CT03 - Validar recurso que não existe
  Cenário: Solicitar um recurso que não existe
    Dado que a API Image Random está acessível
    Quando eu realizo uma busca no GET para o endpoint "breeds/image/pitbull"
    Então eu devo receber status code 404

      # CT04 - Validar recurso que não existe com caracter especial
  Cenário: Validar recurso com caracter especial
    Dado que a API Image Random está acessível
    Quando eu realizo uma busca no GET para o endpoint "breeds/image/labrador-retriever"
    Então eu devo receber status code 404

