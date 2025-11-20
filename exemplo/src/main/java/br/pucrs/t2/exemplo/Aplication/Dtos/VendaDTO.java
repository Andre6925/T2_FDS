package br.pucrs.t2.exemplo.Aplication.Dtos;

public class VendaDTO {

    private long num;
    private long tecnologiaId;
    private String tecnologiaModelo;
    private long compradorCod;
    private String compradorNome;
    private boolean removida;

    public VendaDTO() {}

    public VendaDTO(long num,
                    long tecnologiaId,
                    String tecnologiaModelo,
                    long compradorCod,
                    String compradorNome,
                    boolean removida) {
        this.num = num;
        this.tecnologiaId = tecnologiaId;
        this.tecnologiaModelo = tecnologiaModelo;
        this.compradorCod = compradorCod;
        this.compradorNome = compradorNome;
        this.removida = removida;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public long getTecnologiaId() {
        return tecnologiaId;
    }

    public void setTecnologiaId(long tecnologiaId) {
        this.tecnologiaId = tecnologiaId;
    }

    public String getTecnologiaModelo() {
        return tecnologiaModelo;
    }

    public void setTecnologiaModelo(String tecnologiaModelo) {
        this.tecnologiaModelo = tecnologiaModelo;
    }

    public long getCompradorCod() {
        return compradorCod;
    }

    public void setCompradorCod(long compradorCod) {
        this.compradorCod = compradorCod;
    }

    public String getCompradorNome() {
        return compradorNome;
    }

    public void setCompradorNome(String compradorNome) {
        this.compradorNome = compradorNome;
    }

    public boolean isRemovida() {
        return removida;
    }

    public void setRemovida(boolean removida) {
        this.removida = removida;
    }
}
