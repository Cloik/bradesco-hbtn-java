
import exceptions.OperacaoInvalidaException;

public class ContaBancariaControlada extends ContaBancariaBasica{
    private double saldoMinimo;
    private double valorPenalidade;

    public ContaBancariaControlada(String numeracao, double taxaJurosAnual, double saldoMinimo, double valorPenalidade) {
        super(numeracao, taxaJurosAnual);
        this.saldoMinimo = saldoMinimo;
        this.valorPenalidade = valorPenalidade;
    }

    @Override
    public void aplicarAtualizacaoMensal() {
        double valorAtualizacaoMensal = getSaldo() - calcularTarifaMensal() + calcularJurosMensal();

        if (getSaldo() <= this.saldoMinimo) {
            valorAtualizacaoMensal -= this.valorPenalidade;
        }
        try{
            sacar(getSaldo());
            depositar(valorAtualizacaoMensal);
        }catch (OperacaoInvalidaException e){
            System.out.println(e.getMessage());
        }
    }
}
