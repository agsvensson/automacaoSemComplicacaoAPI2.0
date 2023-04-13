package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import maps.FilmesMap;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class FilmeSteps {

    @Dado("que tenha um payload da API de Filme")
    public void queTenhaUmPayloadDaAPIDeFilme() {
        FilmesMap.initAll();
    }

    @Quando("realizo uma requisicao do tipo POST de Filme")
    public void realizoUmaRequisicaoDoTipoPOSTDeFilme() {
        RestUtils.post(FilmesMap.getHeader(), FilmesMap.getFilme(), ContentType.JSON, "filmes");
    }

    @Entao("armazeno o id que recebo do response de Filme")
    public void armazenoOIdQueReceboDoResponseDeFilme() {
        FilmesMap.id = RestUtils.getResponse().jsonPath().get("id");
    }

    @Quando("realizo uma requisicao do tipo GET de Filme atraves do nome")
    public void realizoUmaRequisicaoDoTipoGETDeFilmeAtravesDoNome() {
        Map<String, String> param = new HashMap<>();
        String nome = FilmesMap.getFilme().get("nome").toString();
        param.put("nome", nome);

        RestUtils.get(FilmesMap.getHeader(), param, "filmes");
    }

    @Dado("altero o campo indice {int} da lista de categorias de filme com os valores")
    public void alteroOCampoIndiceDaListaDeCategoriasDeFilmeComOsValores(int indice, Map<String, String> map) {

    }

    @Quando("realizdo uma requisicao do tipo PUT de Filme")
    public void realizdoUmaRequisicaoDoTipoPUTDeFilme() {
        RestUtils.put(FilmesMap.getHeader(), FilmesMap.getFilme(), ContentType.JSON, "filmes/" + FilmesMap.id);
    }

    @Quando("realizdo uma requisicao do tipo DELETE de Filme")
    public void realizdoUmaRequisicaoDoTipoDELETEDeFilme() {
        RestUtils.delete(FilmesMap.getHeader(), "filmes/" + FilmesMap.id);
    }
}
