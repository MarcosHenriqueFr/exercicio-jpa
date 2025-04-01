package teste.base;

import infra.DAO;
import modelo.base.Produto;

public class CreateProdutoDAO {

    public static void main(String[] args) {
        DAO<Produto> dao = new DAO<>(Produto.class); // O .class caso eu queira fazer um insert
        Produto produto = new Produto("Borracha", 5.25);

        // Bem mais abstrato, facilitando a manipulação dos dados
        dao.abrirT().incluir(produto).fecharT().fechar();
    }
}
