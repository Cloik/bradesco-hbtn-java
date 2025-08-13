
import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {
    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.taxaJurosAnual = taxaJurosAnual;
        this.saldo = 0.0;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void depositar(double valor) throws OperacaoInvalidaException {
        if(valor <= 0){
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) throws OperacaoInvalidaException {
        if(valor <= 0){
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        }
        if(getSaldo() < valor){
            throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
        }
        this.saldo -= valor;
    }

    public double calcularTarifaMensal(){
        double valorTarifaMensal = getSaldo() * 0.10;
        return valorTarifaMensal > 10 ? 10 : valorTarifaMensal;
    }

    public double calcularJurosMensal(){
        if(getSaldo() < 0){
            return 0.0;
        }
        double taxaMensal = taxaJurosAnual / 12 / 100;
        return this.saldo * taxaMensal;
    }

    public void aplicarAtualizacaoMensal(){
        this.saldo = this.saldo - calcularTarifaMensal() + calcularJurosMensal();
    }

}
