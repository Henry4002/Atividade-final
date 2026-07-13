package model;

public class Estoque {

    private int idEstoque;
    private int quantidade;
    private int idProduto;

    public Estoque() {
    }

    public Estoque(int quantidade, int idProduto) {
        this.quantidade = quantidade;
        this.idProduto = idProduto;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
}