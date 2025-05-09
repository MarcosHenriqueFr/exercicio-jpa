package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento2 {

    public static void main(String[] args) {
        Assento assento = new Assento("4D");
        Cliente cliente = new Cliente("Rodrigo", assento);

        DAO<Cliente> dao = new DAO<>(Cliente.class);

        // Não da para adicionar pq ele tenta add o cliente
        // Inclusão automática das minhas fks a partir da criação do meu cliente
        dao.incluirAtomico(cliente);
    }
}
