
import java.io.*;
import java.util.*;

public class Estoque {
    private List<Produto> produtos;
    private String caminhoArquivo;

    public Estoque(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
        this.produtos = new ArrayList<>();
        carregarEstoque();
    }

    private void carregarEstoque() {
        produtos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()){
                    continue;
                }
                String[] partes = linha.split(",");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                int quantidade = Integer.parseInt(partes[2]);
                double preco = Double.parseDouble(partes[3]);
                produtos.add(new Produto(id, nome, quantidade, preco));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o estoque: " + e.getMessage());
        }
    }

    private void salvarEstoque() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Produto p : produtos) {
                bw.write(p.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o estoque: " + e.getMessage());
        }
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        int novoId = gerarNovoId();
        Produto novoProduto = new Produto(novoId, nome, quantidade, preco);
        produtos.add(novoProduto);
        salvarEstoque();
        System.out.println("Produto adicionado com ID: " + novoId);
    }

    private int gerarNovoId() {
        int maiorId = 0;
        for (Produto p : produtos) {
            if (p.getId() > maiorId) {
                maiorId = p.getId();
            }
        }
        return maiorId + 1;
    }

    public void excluirProduto(int id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (removido) {
            salvarEstoque();
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        boolean atualizado = false;
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                atualizado = true;
                break;
            }
        }
        if (atualizado) {
            salvarEstoque();
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }
}



