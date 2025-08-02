package provedores;

public class JadLog implements ProvedorFrete {
    public Frete calcularFrete(double peso, double valor) {
        double frete = (peso > 2000) ? valor * 0.07 : valor * 0.045;
        return new Frete(frete, TipoProvedorFrete.JADLOG);
    }

    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.JADLOG;
    }
}
