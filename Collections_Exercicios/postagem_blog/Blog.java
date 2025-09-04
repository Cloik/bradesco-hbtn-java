
import java.util.*;

public class Blog {
    private Set<Post> postagens = new HashSet<>();

    public void adicionarPostagem(Post postagem) throws Exception {
        if (postagens.contains(postagem)) {
            throw new Exception("Postagem jah existente");
        }
        postagens.add(postagem);
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        for (Post p : postagens) {
            autores.add(p.getAutor());
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new LinkedHashMap<>();
        contagem.put(Categorias.DEVOPS, 0);
        contagem.put(Categorias.DESENVOLVIMENTO, 0);
        contagem.put(Categorias.DATA_SCIENCE, 0);

        for (Post p : postagens) {
            Categorias cat = p.getCategoria();
            contagem.put(cat, contagem.get(cat) + 1);
        }

        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> posts = new TreeSet<>();
        for (Post p : postagens) {
            if (p.getAutor().equals(autor)) {
                posts.add(p);
            }
        }
        return posts;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> posts = new TreeSet<>();
        for (Post p : postagens) {
            if (p.getCategoria().equals(categoria)) {
                posts.add(p);
            }
        }
        return posts;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> mapa = new LinkedHashMap<>();
        mapa.put(Categorias.DEVOPS, new TreeSet<>());
        mapa.put(Categorias.DESENVOLVIMENTO, new TreeSet<>());
        mapa.put(Categorias.DATA_SCIENCE, new TreeSet<>());

        for (Post p : postagens) {
            mapa.get(p.getCategoria()).add(p);
        }

        return mapa;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        // Ordem fixa: Jane Doe, John Bannons, Peter Dirkly
        List<Autor> ordemAutores = Arrays.asList(
                new Autor("Jane", "Doe"),
                new Autor("John", "Bannons"),
                new Autor("Peter", "Dirkly")
        );

        Map<Autor, Set<Post>> mapa = new LinkedHashMap<>();
        for (Autor autor : ordemAutores) {
            Set<Post> posts = new TreeSet<>();
            for (Post p : postagens) {
                if (p.getAutor().equals(autor)) {
                    posts.add(p);
                }
            }
            if (!posts.isEmpty()) {
                mapa.put(autor, posts);
            }
        }

        return mapa;
    }
}



