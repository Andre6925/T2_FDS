package br.pucrs.t2.exemplo.Aplication.Dtos;

public class CompradorDTO {

    private long cod;
    private String nome;
    private String pais;
    private String email;

    public CompradorDTO() {}

    public CompradorDTO(long cod, String nome, String pais, String email) {
        this.cod = cod;
        this.nome = nome;
        this.pais = pais;
        this.email = email;
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
