package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class NovoFilmeAtor {

    public static void main(String[] args) {
        Filme filme1 = new Filme("Star Wars EP 4", 8.7);
        Filme filme2 = new Filme("O fugitivo", 7.3);
        Ator ator1 = new Ator("Harrison Ford");
        Ator ator2 = new Ator("Carrie Fisher");

        // Noções de encapsulamento
        filme1.addAtor(ator1);
        filme1.addAtor(ator2);
        filme2.addAtor(ator1);

        DAO<Filme> dao = new DAO<>();
        // add filme1 -> add ator1 (add filme1 e filme2) e ator2 (add filme1),
        dao.incluirAtomico(filme1); // Faz a operação em cascata de tudo

    }
}
