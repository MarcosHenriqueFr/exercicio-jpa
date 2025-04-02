package teste.base;

import infra.ProdutoDAO;
import modelo.base.Produto;

import java.util.List;

public class SelectProdutoDAO {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.obterTodos(); //com o limite e o offset definidos por padrão

        // Uma abstração maior
        for(Produto p: produtos){
            System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome() + ", Preço: R$" + p.getPreco());
        }

        double precoTotal = produtos.stream()
                        .map(Produto::getPreco)
                        .reduce(0.0, Double::sum);
        System.out.println("Valor total: R$"+ Double.toString(precoTotal).replace(".", ","));

        dao.fechar();
    }
}
