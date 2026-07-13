package dao;

import conexao.Conexao;
import model.Transacoes;

import java.sql.*;
import java.time.LocalDateTime;

public class TransacoesDAO {

    public void realizarTransacao(Transacoes t){

        Connection conn = null;

        try{

            conn = Conexao.conectar();

            conn.setAutoCommit(false);

            String sql1 = "INSERT INTO transacoes(tipo,quantidade,data_hora,id_produto) VALUES(?,?,?,?)";

            PreparedStatement stmt1 = conn.prepareStatement(sql1);

            stmt1.setString(1,t.getTipo());
            stmt1.setInt(2,t.getQuantidade());
            stmt1.setTimestamp(3,Timestamp.valueOf(LocalDateTime.now()));
            stmt1.setInt(4,t.getIdProduto());

            stmt1.executeUpdate();

            String sql2;

            if(t.getTipo().equalsIgnoreCase("ENTRADA")){

                sql2 = "UPDATE estoque SET quantidade = quantidade + ? WHERE id_produto=?";

            }else{

                sql2 = "UPDATE estoque SET quantidade = quantidade - ? WHERE id_produto=?";

            }

            PreparedStatement stmt2 = conn.prepareStatement(sql2);

            stmt2.setInt(1,t.getQuantidade());
            stmt2.setInt(2,t.getIdProduto());

            stmt2.executeUpdate();

            conn.commit();

            System.out.println("Transação realizada!");

        }catch(SQLException e){

            try{

                if(conn!=null)
                    conn.rollback();

            }catch(SQLException ex){
                ex.printStackTrace();
            }

            e.printStackTrace();

        }

    }

}
