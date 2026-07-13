package dao;

import conexao.Conexao;
import model.Transacoes;

import java.sql.*;
import java.time.LocalDateTime;

public class TransacoesDAO {

    public boolean realizarTransacao(Transacoes t){

        Connection conn = null;

        try{

            conn = Conexao.conectar();

            conn.setAutoCommit(false);


            // Verifica estoque antes da saída
            if(t.getTipo().equalsIgnoreCase("SAIDA")){

                String verificar = "SELECT quantidade FROM estoque WHERE id_produto=?";

                PreparedStatement stmtVerificar = conn.prepareStatement(verificar);

                stmtVerificar.setInt(1, t.getIdProduto());

                ResultSet rs = stmtVerificar.executeQuery();


                if(rs.next()){

                    int estoqueAtual = rs.getInt("quantidade");


                    if(t.getQuantidade() > estoqueAtual){

                        System.out.println("Erro: quantidade de saída maior que o estoque disponível!");

                        conn.rollback();

                        return false;

                    }


                }else{

                    System.out.println("Produto não encontrado no estoque!");

                    conn.rollback();

                    return false;

                }

            }



            // Registra a transação
            String sql1 =
                    "INSERT INTO transacoes(tipo,quantidade,data_hora,id_produto) VALUES(?,?,?,?)";


            PreparedStatement stmt1 = conn.prepareStatement(sql1);


            stmt1.setString(1, t.getTipo());

            stmt1.setInt(2, t.getQuantidade());

            stmt1.setTimestamp(
                    3,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            stmt1.setInt(4, t.getIdProduto());


            stmt1.executeUpdate();



            // Atualiza estoque

            String sql2;


            if(t.getTipo().equalsIgnoreCase("ENTRADA")){


                sql2 =
                        "UPDATE estoque SET quantidade = quantidade + ? WHERE id_produto=?";


            }else{


                sql2 =
                        "UPDATE estoque SET quantidade = quantidade - ? WHERE id_produto=?";


            }



            PreparedStatement stmt2 = conn.prepareStatement(sql2);


            stmt2.setInt(1, t.getQuantidade());

            stmt2.setInt(2, t.getIdProduto());


            stmt2.executeUpdate();



            conn.commit();


            System.out.println("Transação realizada!");


            return true;



        }catch(SQLException e){


            try{


                if(conn != null)

                    conn.rollback();


            }catch(SQLException ex){

                ex.printStackTrace();

            }


            e.printStackTrace();


            return false;



        }finally{


            try{


                if(conn != null)

                    conn.close();


            }catch(SQLException e){

                e.printStackTrace();

            }


        }

    }

}