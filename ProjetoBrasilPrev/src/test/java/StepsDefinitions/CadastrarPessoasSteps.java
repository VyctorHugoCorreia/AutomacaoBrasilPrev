package StepsDefinitions;

import BaseTest.VariaveisGlobais;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

import java.util.Map;

import static org.hamcrest.Matchers.is;

public class CadastrarPessoasSteps extends VariaveisGlobais {

    //region String && Final

    private VariaveisGlobais base;

    public CadastrarPessoasSteps(VariaveisGlobais base) {
        this.base = base;
    }
    //endregion

    //region Dado
    @Dado("que o usuário insira uma pessoa com o cpf válido")
    public void QueOUsuarioInsiraUmaPessoaComOCpfValido() throws Throwable {
        CpfPessoa = cpf(false);
        base.response = base.request.get(base.urlDigital);
        base.request.given()
                .body(JsonParaCadastroDePessoa(NomePessoa, CpfPessoa, LogradouroPessoa, NumeroDaCasaPessoa,
                        ComplementoPessoa, BairroPessoa, CidadePessoa, EstadoPessoa, DDDPessoa, NumeroPessoa));
        base.response = base.request.post(base.urlDigitalParaCadastrarPessoa);
    }

    @Dado("^que eu realize o cadastro de uma pessoa com o DDD \"([^\"]*)\" e telefone \"([^\"]*)\"$")
    public void QueEuRealizeOCadastroDeUmaPessoaComODDDETelefone(String DDD, String Telefone) throws Throwable {
        base.request.given()
                .body(JsonParaCadastroDePessoa(NomePessoa, CpfPessoa, LogradouroPessoa, NumeroDaCasaPessoa,
                        ComplementoPessoa, BairroPessoa, CidadePessoa, EstadoPessoa, DDD, Telefone));
        base.response = base.request.post(base.urlDigitalParaCadastrarPessoa);
    }

    @Dado("que o usuário preencha as informações abaixo:")
    public void que_o_usuário_preencha_as_informações_abaixo(DataTable table) throws Throwable {
        Map<String, String> parameters = extractParametersList(table);
        NomePessoa = parameters.get("Nome");
        if (parameters.get("Cpf").equals("")) {
            CpfPessoa = cpf(false);
        } else {
            CpfPessoa = parameters.get("Cpf");
        }
        LogradouroPessoa = parameters.get("logradouro");
        NumeroDaCasaPessoa = parameters.get("Numero");
        ComplementoPessoa = parameters.get("Complemento");
        BairroPessoa = parameters.get("Bairro");
        CidadePessoa = parameters.get("Cidade");
        EstadoPessoa = parameters.get("Estado");
        DDDPessoa = parameters.get("DDD");
        NumeroPessoa = parameters.get("Numero");

    }


    @Dado("que o usuário insira uma pessoa com o cpf inválido")
    public void QueOUsuarioInsiraUmaPessoaComCpfInvalido() throws Throwable {
        CpfPessoa = "CpfFalso" + cpf(false).substring(0, 3);
        System.out.println(CpfPessoa);
        base.response = base.request.get(base.urlDigital);
        base.request.given()
                .body(JsonParaCadastroDePessoa(NomePessoa, CpfPessoa, LogradouroPessoa, NumeroDaCasaPessoa,
                        ComplementoPessoa, BairroPessoa, CidadePessoa, EstadoPessoa, DDDPessoa, NumeroPessoa));
        base.response = base.request.post(base.urlDigitalParaCadastrarPessoa);
    }


    @Dado("que o usuário insira uma pessoa com o telefone válido")
    public void QueOUsuarioInsiraUmaPessoaComOtelefoneValido() throws Throwable {
        NumeroPessoa = cpf(false).substring(0, 9);
        base.response = base.request.get(base.urlDigital);
        base.request.given()
                .body(JsonParaCadastroDePessoa(NomePessoa, CpfPessoa, LogradouroPessoa, NumeroDaCasaPessoa,
                        ComplementoPessoa, BairroPessoa, CidadePessoa, EstadoPessoa, DDDPessoa, NumeroPessoa));

        base.response = base.request.post(base.urlDigitalParaCadastrarPessoa);
    }

    //endregion

    //region Quando
    @Quando("o usuário inserir uma nova pessoa com o mesmo cpf")
    public void OUsuarioInserirUmaNovaPessoaComOMesmoCpf() throws Throwable {
        base.request.given()
                .body(JsonParaCadastroDePessoa(NomePessoa, CpfPessoa, LogradouroPessoa, NumeroDaCasaPessoa,
                        ComplementoPessoa, BairroPessoa, CidadePessoa, EstadoPessoa, DDDPessoa, NumeroPessoa));
        base.response = base.request.post(base.urlDigitalParaCadastrarPessoa);
    }

    @Quando("o usuário inserir uma nova pessoa com o mesmo telefone")
    public void OUsuarioInserirUmaNovaPessoaComOMesmoTelefone() throws Throwable {
        CpfPessoa = cpf(false);
        base.request.given()
                .body(JsonParaCadastroDePessoa(NomePessoa, CpfPessoa, LogradouroPessoa, NumeroDaCasaPessoa,
                        ComplementoPessoa, BairroPessoa, CidadePessoa, EstadoPessoa, DDDPessoa, NumeroPessoa));
        base.response = base.request.post(base.urlDigitalParaCadastrarPessoa);
    }

    @Quando("realizar o post no endpoint")
    public void RealizarOPostNoEndpoint() throws Throwable {
        base.request.given()
                .body(JsonParaCadastroDePessoa(NomePessoa, CpfPessoa, LogradouroPessoa, NumeroDaCasaPessoa,
                        ComplementoPessoa, BairroPessoa, CidadePessoa, EstadoPessoa, DDDPessoa, NumeroPessoa));
        base.response = base.request.post(base.urlDigitalParaCadastrarPessoa);
    }
    //endregion

    //region Então
    @Então("o status code retornado de cadastro de pessoa é \"([^\"]*)\"$")
    public void OStatusCodeRetornadoE(int StatusCode) throws Throwable {
        base.response.then().statusCode(StatusCode);
        if (StatusCode == 201) {
            base.response.then().statusCode(201).body("nome", is(NomePessoa));
        }
    }

    @Então("o json cadastrado tem as informações:")
    public void OJsonCadastradoTemAsInformacoes(DataTable table) throws Throwable {
        Map<String, String> parameters = extractParametersList(table);
        base.response.then().statusCode(201).body("nome", is(parameters.get("Nome")));
        base.response.then().statusCode(201).body("cpf", is(parameters.get("Cpf")));
        Assert.assertTrue(base.response.getBody().asString().contains(parameters.get("Numero")));
        Assert.assertTrue(base.response.getBody().asString().contains(parameters.get("logradouro")));
        Assert.assertTrue(base.response.getBody().asString().contains(parameters.get("Complemento")));
        Assert.assertTrue(base.response.getBody().asString().contains(parameters.get("Bairro")));
        Assert.assertTrue(base.response.getBody().asString().contains(parameters.get("Cidade")));
        Assert.assertTrue(base.response.getBody().asString().contains(parameters.get("Estado")));
        Assert.assertTrue(base.response.getBody().asString().contains(parameters.get("DDD")));
        Assert.assertTrue(base.response.getBody().asString().contains(parameters.get("Numero")));
    }
    //endregion

    //region E
    @E("é exibido a mensagem de erro para cadastrar pessoa com cpf já cadastrado")
    public void EExibidoAMensagemDeErroParaCadastrarPessoaComCpfJaCadastrado() throws Throwable {
        base.response.then().statusCode(400).body("erro", is("Já existe pessoa cadastrada com o CPF " + CpfPessoa));
    }

    @E("é exibido a mensagem de erro para cadastrar pessoa com telefone já cadastrado")
    public void EExibidoAMensagemDeErroParaCadastrarPessoaComTelefoneJaCadastrado() throws Throwable {
        base.response.then().statusCode(400).body("erro", is("Já existe pessoa cadastrada com o Telefone (" + DDDPessoa + ")" + NumeroPessoa));
    }

    @E("é exibido a mensagem de erro para cadastrar pessoa com cpf inválido")
    public void EExibidoAMensagemDeErroParaCadastrarPessoaComCpfInvalido() throws Throwable {
        base.response.then().statusCode(400).body("erro", is("Cpf inválido!"));
    }
    //endregion

}
