package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {

    public static void main(String[] args) {
        Assento assento = new Assento("10G");
        Cliente cliente = new Cliente("Milena", assento);

        DAO<Object> dao = new DAO<>(); //persisto os dois
        dao.abrirT()
                .incluir(assento)
                .incluir(cliente)
                .fecharT()
                .fechar();

        System.out.println("Incluido");
    }
}
