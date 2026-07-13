package dao;

import conexao.Conexao;
import model.Estoque;
import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void salvarProduto(Produto produto){

        String sql = "INSERT INTO produto(nome, descricao, id_fornecedor) VALUES(?,?,?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(3, produto.getIdFornecedor());

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idProdutoGerado = generatedKeys.getInt(1);

                    EstoqueDAO estoqueDAO = new EstoqueDAO();
                    Estoque novoEstoque = new Estoque();
                    novoEstoque.setIdProduto(idProdutoGerado);
                    novoEstoque.setQuantidade(0);

                    estoqueDAO.salvarEstoque(novoEstoque);
                }
            }

            System.out.println("Produto e estoque inicial cadastrados com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Produto> listarProdutos(){

        List<Produto> lista = new ArrayList<>();

        String sql = "SELECT * FROM produto";

        try(Connection conn = Conexao.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){

                Produto p = new Produto();

                p.setIdProduto(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setIdFornecedor(rs.getInt("id_fornecedor"));

                lista.add(p);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}