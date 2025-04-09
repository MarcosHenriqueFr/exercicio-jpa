package teste.consulta;

import infra.DAO;
import modelo.consulta.NotaFilme;

public class ObterMediaFilmes {

    public static void main(String[] args) {
        DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);

        NotaFilme nota = dao.consultarUm("obterMediaGeralDosFilmes");

        System.out.println("A média de todos os filmes: " + nota.getMedia());

        dao.fechar();
    }
}
