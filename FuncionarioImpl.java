import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class FuncionarioImpl implements Funcionario {
    private BigDecimal salario;

    private int ano;

    @Override
    public BigDecimal getSalario() {
        return salario;
    }

    @Override
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Override
    public int getAno() {
        return ano;
    }

    @Override
    public void setAno(int ano) {
        this.ano = ano;
    }

    public FuncionarioImpl(BigDecimal salario, int ano) {
        this.salario = salario;
        this.ano = ano;
    }

    @Override
    public List<Map<String, String>> getSalarioMeses(){
        List<Map<String, String>> list = new ArrayList<>();
        for (Month month : Month.values()) {
            int diasUteis = 0;
            LocalDate date = LocalDate.of(this.ano, month, 01).with(TemporalAdjusters.lastDayOfMonth());
            for (int i = 1; i<=date.getDayOfMonth(); i++) {
                LocalDate date1 = LocalDate.of(this.ano, month, i);
                if(DiaUtil(date1)){
                    diasUteis++;
                }
            }
            String valor = NumberFormat.getCurrencyInstance().format(salario.multiply(BigDecimal.valueOf(1.05).pow(diasUteis)));
            Locale local = new Locale("pt", "BR");
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMMM", local);
            String mes = date.format(fmt);
            mes = mes.substring(0,1).toUpperCase() + mes.substring(1);
            list.add(Map.of("mes", mes, "salario", valor));
        }
        return list;
    }

    @Override
    public boolean DiaUtil(LocalDate localDate){
        DayOfWeek d = localDate.getDayOfWeek();
        return d != DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY;
    }
}
