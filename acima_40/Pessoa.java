package idade_por_cargo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Pessoa {
    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("0.000000", symbols);
        return String.format("[%d] %s %s %d R$ %s", codigo, nome, cargo, idade, df.format(salario));
    }
}

