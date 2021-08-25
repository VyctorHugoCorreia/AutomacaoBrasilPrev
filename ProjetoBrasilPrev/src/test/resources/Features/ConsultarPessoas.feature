#language: pt
Funcionalidade: Eu como usuário quero conseguir realizar a busca de pessoas preenchendo seu DDD e telefone


  Cenário: Validar se é possível buscar pessoas por DDD e telefone
    Dado que eu realize o cadastro de uma pessoa com o DDD "11" e telefone "40028922"
    E que eu possua o DDD "11" e telefone "40028922" da pessoa
    Quando eu realizar a requisição no endpoint
    Então o status code retornado é "200"

  Cenário: Validar se é exibido mensagem de erro ao realizar busca por DDD inválido
    Dado que eu possua o DDD "1452" e telefone "40028922" da pessoa
    Quando eu realizar a requisição no endpoint
    Então o status code retornado é "404"
    E é exibido a mensagem de erro "Não existe pessoa com o telefone (1452)40028922"

  Cenário: Validar se é exibido mensagem de erro ao realizar busca por Telefone inválido
    Dado que eu possua o DDD "11" e telefone "7678452" da pessoa
    Quando eu realizar a requisição no endpoint
    Então o status code retornado é "404"
    E é exibido a mensagem de erro "Não existe pessoa com o telefone (11)7678452"

  Cenário: Validar estrutura json
    Dado que eu realize o cadastro de uma pessoa com o DDD "11" e telefone "40028922"
    E que eu possua o DDD "11" e telefone "40028922" da pessoa
    Quando eu realizar a requisição no endpoint
    Então o status code retornado é "200"
    E é exibido corretamente todos os parâmetros




