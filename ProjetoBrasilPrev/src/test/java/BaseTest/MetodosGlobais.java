package BaseTest;

import cucumber.api.DataTable;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class MetodosGlobais {
    Random random = new Random();
    int NumeroAleatorio = random.nextInt(100);

    private int Random(int n) {
        int ranNum = (int) (Math.random() * n);
        return ranNum;
    }

    private int Mod(int dividendo, int divisor) {
        return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
    }

    public String cpf(boolean comPontos) {
        int n = 9;
        int n1 = Random(n);
        int n2 = Random(n);
        int n3 = Random(n);
        int n4 = Random(n);
        int n5 = Random(n);
        int n6 = Random(n);
        int n7 = Random(n);
        int n8 = Random(n);
        int n9 = Random(n);
        int d1 = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

        d1 = 11 - (Mod(d1, 11));

        if (d1 >= 10)
            d1 = 0;

        int d2 = d1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

        d2 = 11 - (Mod(d2, 11));

        String retorno = null;

        if (d2 >= 10)
            d2 = 0;
        retorno = "";

        if (comPontos)
            retorno = "" + n1 + n2 + n3 + "." + n4 + n5 + n6 + "." + n7 + n8 + n9 + "-" + d1 + d2;
        else
            retorno = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + d1 + d2;

        return retorno;
    }

    public Map<String, String> extractParametersList(DataTable dataTable){
        return extractParametersMultList(dataTable).get(0);
    }
    public List<Map<String, String>> extractParametersMultList(DataTable dataTable){
        return dataTable.asMaps(String.class, String.class);
    }
}
