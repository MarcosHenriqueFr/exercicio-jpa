package teste.umpramuitos;

import infra.DAO;
import modelo.base.Produto;
import modelo.umpramuitos.ItemPedido;
import modelo.umpramuitos.Pedido;

public class NovoPedido {

    public static void main(String[] args) {
        DAO<Object> dao = new DAO<>();

        // Teriam alguns detalhes a mais
        Produto produto = new Produto("Notebook", 3280.90);
        Pedido pedido = new Pedido();
        ItemPedido item = new ItemPedido(pedido, produto, 20);

        dao.abrirT()
            .incluir(produto)
            .incluir(pedido)
            .incluir(item)
            .fecharT()
            .fechar();
    }
}
