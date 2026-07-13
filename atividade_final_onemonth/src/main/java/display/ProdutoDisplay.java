package display;

import dao.ProdutoDAO;
import model.Produto;

import javax.swing.*;
import java.awt.*;

public class ProdutoDisplay extends JFrame {

    private JTextField txtNome;
    private JTextField txtDescricao;
    private JTextField txtFornecedor;


    public ProdutoDisplay() {


        Estilo.configurarJanela(
                this,
                "Cadastro de Produto",
                500,
                300
        );


        JPanel painel = new JPanel(
                new GridLayout(4, 2, 15, 15)
        );

        Estilo.configurarPainel(painel);



        painel.add(
                Estilo.criarLabel("Nome")
        );

        txtNome = new JTextField();

        Estilo.configurarCampo(txtNome);

        painel.add(txtNome);



        painel.add(
                Estilo.criarLabel("Descrição")
        );

        txtDescricao = new JTextField();

        Estilo.configurarCampo(txtDescricao);

        painel.add(txtDescricao);



        painel.add(
                Estilo.criarLabel("ID Fornecedor")
        );

        txtFornecedor = new JTextField();

        Estilo.configurarCampo(txtFornecedor);

        painel.add(txtFornecedor);



        BotaoArredondado btnSalvar =
                new BotaoArredondado("Cadastrar");


        BotaoArredondado btnListar =
                new BotaoArredondado("Listar");



        painel.add(btnSalvar);

        painel.add(btnListar);



        add(painel);



        btnSalvar.addActionListener(e -> {


            try {


                Produto produto = new Produto();


                produto.setNome(
                        txtNome.getText()
                );


                produto.setDescricao(
                        txtDescricao.getText()
                );


                produto.setIdFornecedor(
                        Integer.parseInt(
                                txtFornecedor.getText()
                        )
                );


                new ProdutoDAO()
                        .salvarProduto(produto);



                JOptionPane.showMessageDialog(
                        null,
                        "Produto cadastrado com sucesso!"
                );


                txtNome.setText("");
                txtDescricao.setText("");
                txtFornecedor.setText("");



            } catch(NumberFormatException ex){


                JOptionPane.showMessageDialog(
                        null,
                        "Informe um ID de fornecedor válido!"
                );

            }


        });



        btnListar.addActionListener(e -> {


            JTextArea area =
                    Estilo.criarArea();


            StringBuilder sb =
                    new StringBuilder();



            for(Produto p :
                    new ProdutoDAO().listarProdutos()){


                sb.append(
                                "ID: "
                        )
                        .append(p.getIdProduto())


                        .append("\nNome: ")
                        .append(p.getNome())


                        .append("\nDescrição: ")
                        .append(p.getDescricao())


                        .append("\nFornecedor: ")
                        .append(p.getIdFornecedor())


                        .append("\n----------------------------\n");


            }



            area.setText(
                    sb.toString()
            );



            JOptionPane.showMessageDialog(
                    null,
                    new JScrollPane(area),
                    "Produtos cadastrados",
                    JOptionPane.INFORMATION_MESSAGE
            );


        });


    }

}