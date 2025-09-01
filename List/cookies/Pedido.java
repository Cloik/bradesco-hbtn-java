
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private final List<PedidoCookie> cookies;

    public Pedido() {
        cookies = new ArrayList<>();
    }

    public void adicionarPedidoCookie(PedidoCookie pedido){
        cookies.add(pedido);
    }

    public int obterTotalCaixas(){
        int totalCaixas = 0;
        for (int i = 0; i < cookies.size(); i++) {
            totalCaixas += cookies.get(i).getQuantidadeCaixas();
        }
        return totalCaixas;
    }

    public int removerSabor(String sabor){
        int totalCaixasRemovidas = 0;
        for (int i = 0; i < cookies.size(); i++) {
            if(cookies.get(i).getSabor().equalsIgnoreCase(sabor)){
                totalCaixasRemovidas += cookies.get(i).getQuantidadeCaixas();
                cookies.remove(i);
            }
        }
        return totalCaixasRemovidas;
    }
}
