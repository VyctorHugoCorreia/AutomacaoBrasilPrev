package StepsDefinitions;

import BaseTest.VariaveisGlobais;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Quando;
import cucumber.api.java.pt.Então;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ConsultarPessoasSteps extends VariaveisGlobais {

    //region String && Final
    private VariaveisGlobais base;
    private String endpoint = "";

    public ConsultarPessoasSteps(VariaveisGlobais base) {
        this.base = base;
    }
    //endregion

    //region Dado
    @Dado("que eu possua o DDD \"([^\"]*)\" e telefone \"([^\"]*)\" da pessoa")
    public void QueEuPossuaODDDETelefoneDaPessoa(String DDD, String Telefone) throws Throwable {
        DDDPessoa = DDD;
        NumeroPessoa = Telefone;
        endpoint = DDD + "/" + Telefone;
    }
    //endregion

    //region Quando
    @Quando("eu realizar a requisição no endpoint")
    public void EuRealizarARequisicaoNoEndPoint() throws Throwable {
        base.response = base.request.get(base.urlDigital + endpoint);
    }
    //endregion

    //region Então
    @Então("o status code retornado é \"([^\"]*)\"$")
    public void OStatusCodeRetornadoE(int StatusCode) throws Throwable {
        base.response.then().statusCode(StatusCode);
        if (StatusCode == 200) {
            base.response.then().statusCode(200).body("nome", is("Qualidade"));
        }
    }
    //endregion

    //region E
    @E("é exibido a mensagem de erro \"([^\"]*)\"$")
    public void ExibidoAMensagemDeErro(String MensagemDeErro) throws Throwable {
        base.response.then().statusCode(404).body("erro", is(MensagemDeErro));
    }

    @E("é exibido corretamente todos os parâmetros")
    public void ExibidoCorretamenteTodosOsParametros() throws Throwable {
        base.response.then().statusCode(200).body("codigo", notNullValue());
        base.response.then().statusCode(200).body("nome", notNullValue());
        base.response.then().statusCode(200).body("cpf", notNullValue());
        base.response.then().statusCode(200).body("enderecos", notNullValue());
        base.response.then().statusCode(200).body("enderecos.logradouro", notNullValue());
        base.response.then().statusCode(200).body("enderecos.numero", notNullValue());
        base.response.then().statusCode(200).body("enderecos.complemento", notNullValue());
        base.response.then().statusCode(200).body("enderecos.Empresa", notNullValue());
        base.response.then().statusCode(200).body("enderecos.bairro", notNullValue());
        base.response.then().statusCode(200).body("enderecos.cidade", notNullValue());
        base.response.then().statusCode(200).body("enderecos.estado", notNullValue());
        base.response.then().statusCode(200).body("telefones", notNullValue());
        base.response.then().statusCode(200).body("telefones.ddd", notNullValue());
        base.response.then().statusCode(200).body("telefones.numero", notNullValue());
    }
    //endregion

}
