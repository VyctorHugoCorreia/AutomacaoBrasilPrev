package BaseTest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VariaveisGlobais extends MetodosGlobais {

    public Response response;
    public RequestSpecification request;
    public String urlDigital = "http://localhost:8080/pessoas/";
    public String urlDigitalParaCadastrarPessoa = "http://localhost:8080/pessoas";
    public String NomePessoa = "Qualidade";
    public String CpfPessoa = cpf(false);
    public String LogradouroPessoa = "Rua Alexandre Dumas";
    public String NumeroDaCasaPessoa = "123";
    public String ComplementoPessoa = "Empresa";
    public String BairroPessoa = "Chacara Santo Antonio";
    public String CidadePessoa = "São Paulo";
    public String EstadoPessoa = "SP";
    public String DDDPessoa = ""+ NumeroAleatorio;
    public String NumeroPessoa = cpf(false).substring(0,9);

    public String JsonParaCadastroDePessoa(String Nome, String Cpf, String Logradouro, String NumeroDaCasa, String Complemento,
                                           String Bairro, String Cidade, String Estado, String DDD, String Numero) {
        return "{\n" +
                "\"codigo\": 0,\n" +
                "\"nome\": \"" + Nome + "\",\n" +
                "\"cpf\": \"" + Cpf + "\",\n" +
                "\"enderecos\": [\n" +
                "{\n" +
                "\"logradouro\": \"" + Logradouro + "\",\n" +
                "\"numero\": " + Numero + ",\n" +
                "\"complemento\": \"" + Complemento + "\",\n" +
                "\"bairro\": \"" + Bairro + "\",\n" +
                "\"cidade\": \"" + Cidade + "\",\n" +
                "\"estado\": \"" + Estado + "\"\n" +
                "}\n" +
                "],\n" +
                "\"telefones\": [\n" +
                "{\n" +
                "\"ddd\": \"" + DDD + "\",\n" +
                "\"numero\": \"" + Numero + "\"\n" +
                "}]\n" +
                "}\n";
    }
}
