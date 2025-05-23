package modelo.composicao;

// Dados são adicionados dentro da tabela
// Se for ter que reconstruir o endereço tem que remover da tabela que usa essa classe
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

    private String logradouro;
    private String complemento;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
