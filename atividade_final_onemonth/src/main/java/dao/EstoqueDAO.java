package dao;

import conexao.Conexao;
import model.Estoque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {

    public void salvarEstoque(Estoque estoque){

        String sql = "INSERT INTO estoque(quantidade,id_produto) VALUES(?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, estoque.getQuantidade());
            stmt.setInt(2, estoque.getIdProduto());

            stmt.executeUpdate();

            System.out.println("Estoque cadastrado!");

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public List<Estoque> listarEstoque(){

        List<Estoque> lista = new ArrayList<>();

        String sql = "SELECT * FROM estoque";

        try(Connection conn = Conexao.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){

                Estoque e = new Estoque();

                e.setIdEstoque(rs.getInt("id_estoque"));
                e.setQuantidade(rs.getInt("quantidade"));
                e.setIdProduto(rs.getInt("id_produto"));

                lista.add(e);

            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return lista;
    }

}