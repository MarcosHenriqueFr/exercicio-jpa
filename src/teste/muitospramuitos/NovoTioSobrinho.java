package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Sobrinho;
import modelo.muitospramuitos.Tio;

public class NovoTioSobrinho {

    public static void main(String[] args) {
        Tio tio1 = new Tio("Mario");
        Tio tia1 = new Tio("Madalena");

        Sobrinho sob1 = new Sobrinho("Pedro");
        Sobrinho sob2 = new Sobrinho("Sofia");

        // Manter coerencia na relação, duas direções, pode ser mais rápido
        tia1.getSobrinhos().add(sob1);
        sob1.getTios().add(tia1);

        tia1.getSobrinhos().add(sob2);
        sob2.getTios().add(tia1);

        tio1.getSobrinhos().add(sob1);
        sob1.getTios().add(tio1);

        tio1.getSobrinhos().add(sob2);
        sob2.getTios().add(tio1);

        DAO<Object> dao = new DAO<>();

        dao.abrirT()
                .incluir(tia1)
                .incluir(tio1)
                .incluir(sob1)
                .incluir(sob2)
                .fecharT()
                .fechar();
    }
}
