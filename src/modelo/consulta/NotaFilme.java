package modelo.consulta;

public class NotaFilme {

    // Consulta nativa para pegar todos os filmes da minha base
    private Double media;

    public NotaFilme(Double media) {
        this.media = media;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }
}
