package dao;

import conexao.Conexao;
import model.Fornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    public void salvarFornecedor(Fornecedor fornecedor) {

        String sql = "INSERT INTO fornecedor(nome, telefone, email) VALUES(?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getTelefone());
            stmt.setString(3, fornecedor.getEmail());

            stmt.executeUpdate();

            System.out.println("Fornecedor cadastrado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Fornecedor> listarFornecedores(){

        List<Fornecedor> lista = new ArrayList<>();

        String sql = "SELECT * FROM fornecedor";

        try(Connection conn = Conexao.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){

                Fornecedor f = new Fornecedor();

                f.setIdFornecedor(rs.getInt("id_fornecedor"));
                f.setNome(rs.getString("nome"));
                f.setTelefone(rs.getString("telefone"));
                f.setEmail(rs.getString("email"));

                lista.add(f);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return lista;
    }
}
