package model;

import java.time.LocalDateTime;

public class Transacoes {

    private int idTransacoes;
    private String tipo;
    private int quantidade;
    private LocalDateTime dataHora;
    private int idProduto;

    public Transacoes() {
    }

    public Transacoes(String tipo, int quantidade, LocalDateTime dataHora, int idProduto) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.dataHora = dataHora;
        this.idProduto = idProduto;
    }

    public int getIdTransacoes() {
        return idTransacoes;
    }

    public void setIdTransacoes(int idTransacoes) {
        this.idTransacoes = idTransacoes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
}