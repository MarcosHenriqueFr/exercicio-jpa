package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {

    public static void main(String[] args) {
        Assento assento = new Assento("16C");
        Cliente cLiente = new Cliente("Ana", assento);

        DAO<Object> dao = new DAO<>(); //persisto os dois
        dao.abrirT()
                .incluir(assento)
                .incluir(cLiente)
                .fecharT()
                .fechar();

        System.out.println("Incluido");
    }
}
