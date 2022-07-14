import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface Funcionario {
    BigDecimal getSalario();

    void setSalario(BigDecimal salario);

    int getAno();

    void setAno(int ano);

    List<Map<String, String>> getSalarioMeses();

    boolean DiaUtil(LocalDate localDate);
}
