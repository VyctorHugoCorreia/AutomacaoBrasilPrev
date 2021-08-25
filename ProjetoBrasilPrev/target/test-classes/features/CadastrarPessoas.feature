#language: pt
Funcionalidade: Eu como usuário quero conseguir realizar o cadastro de uma pessoa

  Cenario: Validar se não é permitido cadastrar duas pessoas com o mesmo cpf
    Dado que o usuário insira uma pessoa com o cpf válido
    Quando o usuário inserir uma nova pessoa com o mesmo cpf
    Então o status code retornado de cadastro de pessoa é "400"
    E é exibido a mensagem de erro para cadastrar pessoa com cpf já cadastrado

  Cenario: Validar se não é permitido cadastrar duas pessoas com o mesmo telefone
    Dado que o usuário insira uma pessoa com o telefone válido
    Quando o usuário inserir uma nova pessoa com o mesmo telefone
    Então o status code retornado de cadastro de pessoa é "400"
    E é exibido a mensagem de erro para cadastrar pessoa com telefone já cadastrado

  Cenario: Validar se é permitido realizar cadastro de pessoa
    Dado que o usuário insira uma pessoa com o cpf válido
    Então o status code retornado de cadastro de pessoa é "201"

  @Bug #Não deve ser possível realizar o cadastro de um cpf inválido como "CpfFalso123"#
  Cenario: Validar se é permitido realizar cadastro com CPF inválido
    Dado que o usuário insira uma pessoa com o cpf inválido
    Então o status code retornado de cadastro de pessoa é "400"
    E é exibido a mensagem de erro para cadastrar pessoa com cpf inválido

    #Para execução deste cenário é necessário alterar os valores de CPF, DDD e Numero#
  Cenario: Validar cadastro de pessoa preenchendo os campos manualmente
    Dado que o usuário preencha as informações abaixo:
      | Nome   |  | Cpf         |  | logradouro   |  | Numero |  | Complemento |  | Bairro  |  | Cidade       |  | Estado |  | DDD |  | Numero    |
      | Tester |  | 52844151147 |  | Rua catarina |  | 631    |  | Em casa     |  | Caiçara |  | Praia Grande |  | SP     |  | 5   |  | 916018351 |
    Quando realizar o post no endpoint
    Então o status code retornado de cadastro de pessoa é "201"
    E o json cadastrado tem as informações:
      | Nome   |  | Cpf         |  | logradouro   |  | Numero |  | Complemento |  | Bairro  |  | Cidade       |  | Estado |  | DDD |  | Numero    |
      | Tester |  | 52844151147 |  | Rua catarina |  | 631    |  | Em casa     |  | Caiçara |  | Praia Grande |  | SP     |  | 5   |  | 916018351 |