package infra;

import modelo.base.Produto;

// Resolvendo com a herança em classes
public class ProdutoDAO extends DAO<Produto> {

    public ProdutoDAO() {
        super(Produto.class); // passando o construtor especifico
    }
}
