#language:pt

@filme
Funcionalidade: CRUD Filme

  Contexto:
    Dado que tenha realizado o login com dados validos
    E que tenha um payload da API de Filme

  @cadastroFilme
  Cenario: Cadastro Filme
    Quando realizo uma requisicao do tipo POST de Filme
    Entao valido que recebo status 201 no response
    E valido que no campo "categorias.tipo[1]" possui o valor "Comedia"
    E armazeno o id que recebo do response de Filme

  @consultaFilme
  Cenario: Consulta Filme
    Quando realizo uma requisicao do tipo GET de Filme atraves do nome
    Entao valido que recebo status 200 no response
    E valido que no campo "categorias[0].tipo[1]" possui o valor "Comedia"

  @alteraFilme
  Cenario: Alteracao Filme
    E altero o campo indice 0 da lista de categorias de filme com os valores
      | tipo | Comedia |
    E altero o campo indice 1 da lista de categorias de filme com os valores
      | tipo | Terror |
    Quando realizdo uma requisicao do tipo PUT de Filme
    Entao valido que recebo status 200 no response
    E valido que no campo "categorias.tipo[0]" possui o valor "Comedia"
    E valido que no campo "categorias.tipo[1]" possui o valor "Terror"

  @deletaFilme
  Cenario: Exclusao Filme
    Quando realizdo uma requisicao do tipo DELETE de Filme
    Entao valido que recebo status 200 no response

  Cenario: Consulta Filme apos Exclusao
    Quando realizo uma requisicao do tipo GET de Filme atraves do nome
    Entao valido que recebo status 404 no response
    E valido que recebo uma lista vazia no response


