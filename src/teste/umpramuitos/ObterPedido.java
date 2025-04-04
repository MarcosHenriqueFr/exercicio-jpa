package teste.umpramuitos;

import infra.DAO;
import modelo.umpramuitos.ItemPedido;
import modelo.umpramuitos.Pedido;

public class ObterPedido {

    public static void main(String[] args) {
        DAO< Pedido> dao = new DAO<>(Pedido.class);

        // Consulta -> obter pedido, nenhuma relação many, puxa diretamente
        Pedido pedido = dao.obterPorId(1L);

        // Outra consulta -> pega tardiamente - many itens
        for(ItemPedido item: pedido.getItens()){
            System.out.println(item.getQuantidade() + " itens");
            System.out.println(item.getProduto().getNome());
        }

        dao.fechar();
    }
}
