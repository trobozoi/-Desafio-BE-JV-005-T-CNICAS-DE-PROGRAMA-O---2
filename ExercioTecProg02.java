import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ExercioTecProg02 {
    public static void main(String[] args) {
        Funcionario funcionario = new FuncionarioImpl(BigDecimal.valueOf(1000), 2002);
        List<Map<String, String>> list = funcionario.getSalarioMeses();
        System.out.println("Previsão do Salário mês a mês");
        for (Map<String, String> stringStringMap :
                list) {
            System.out.printf("%-10s : %10s\n", stringStringMap.get("mes").toString(), stringStringMap.get("salario").toString());
        }
    }
}
