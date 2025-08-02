package provedores;

public class Loggi implements ProvedorFrete {
    public Frete calcularFrete(double peso, double valor) {
        double frete = (peso > 5000) ? valor * 0.12 : valor * 0.04;
        return new Frete(frete, TipoProvedorFrete.LOGGI);
    }

    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.LOGGI;
    }
}
