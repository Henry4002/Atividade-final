package display;

import dao.EstoqueDAO;
import model.Estoque;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EstoqueDisplay extends JFrame {


    private JTable tabela;
    private DefaultTableModel modelo;


    public EstoqueDisplay() {


        Estilo.configurarJanela(
                this,
                "Consulta de Estoque",
                600,
                400
        );


        JPanel painel = new JPanel(new BorderLayout(10,10));

        Estilo.configurarPainel(painel);



        // Modelo da tabela

        modelo = new DefaultTableModel(
                new Object[]{
                        "ID Estoque",
                        "ID Produto",
                        "Quantidade"
                },
                0
        );


        tabela = new JTable(modelo);


        tabela.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );


        tabela.setRowHeight(25);



        JScrollPane scroll =
                new JScrollPane(tabela);



        // Botão

        BotaoArredondado btnListar =
                new BotaoArredondado(
                        "Consultar Estoque"
                );



        JPanel topo = new JPanel();

        topo.add(btnListar);



        painel.add(
                topo,
                BorderLayout.NORTH
        );


        painel.add(
                scroll,
                BorderLayout.CENTER
        );


        add(painel);



        btnListar.addActionListener(e -> {


            modelo.setRowCount(0);



            EstoqueDAO dao =
                    new EstoqueDAO();



            for(Estoque estoque :
                    dao.listarEstoque()){



                modelo.addRow(
                        new Object[]{

                                estoque.getIdEstoque(),

                                estoque.getIdProduto(),

                                estoque.getQuantidade()

                        }
                );


            }


        });


    }

}