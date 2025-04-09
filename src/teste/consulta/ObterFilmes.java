package teste.consulta;

import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

import java.util.List;

public class ObterFilmes {

    public static void main(String[] args) {
        // Quando quero fazer uma consulta, tenho que passar o meu filme de forma reflect
        DAO<Filme> dao = new DAO<>(Filme.class);

        // O nome bate com minha named query
        // Os parametros são passados de forma chave e valor
        List<Filme> filmes = dao.consultar("obterFilmesComNotaMaiorQue", "nota", 8.5);

        System.out.println("Foram puxados " + filmes.size() + " filmes.");
        
        for(Filme f: filmes){
            System.out.println("Filme: " + f.getNome());

            System.out.println("Atores desse filme: ");
            for(Ator ator: f.getAtores()){
                System.out.println("Ator: " + ator.getNome());
            }
        }
    }
}
