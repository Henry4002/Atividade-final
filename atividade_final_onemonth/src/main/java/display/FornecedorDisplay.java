package display;

import dao.FornecedorDAO;
import model.Fornecedor;

import javax.swing.*;
import java.awt.*;

public class FornecedorDisplay extends JFrame {


    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEmail;


    public FornecedorDisplay(){


        Estilo.configurarJanela(
                this,
                "Cadastro de Fornecedor",
                500,
                300
        );


        JPanel painel = new JPanel(new GridLayout(4,2,15,15));

        Estilo.configurarPainel(painel);



        painel.add(Estilo.criarLabel("Nome"));

        txtNome = new JTextField();
        Estilo.configurarCampo(txtNome);

        painel.add(txtNome);



        painel.add(Estilo.criarLabel("Telefone"));

        txtTelefone = new JTextField();

        painel.add(txtTelefone);



        painel.add(Estilo.criarLabel("Email"));

        txtEmail = new JTextField();

        painel.add(txtEmail);



        BotaoArredondado salvar =
                new BotaoArredondado("Cadastrar");


        BotaoArredondado listar =
                new BotaoArredondado("Listar");


        painel.add(salvar);
        painel.add(listar);



        add(painel);



        salvar.addActionListener(e->{


            Fornecedor f = new Fornecedor();

            f.setNome(txtNome.getText());

            f.setTelefone(txtTelefone.getText());

            f.setEmail(txtEmail.getText());


            new FornecedorDAO()
                    .salvarFornecedor(f);



            JOptionPane.showMessageDialog(
                    null,
                    "Fornecedor cadastrado!"
            );


            txtNome.setText("");
            txtTelefone.setText("");
            txtEmail.setText("");

        });



        listar.addActionListener(e->{


            JTextArea area = Estilo.criarArea();


            StringBuilder sb = new StringBuilder();


            for(Fornecedor f:
                    new FornecedorDAO().listarFornecedores()){


                sb.append(
                                "ID: "
                        ).append(f.getIdFornecedor())

                        .append("\nNome: ")
                        .append(f.getNome())

                        .append("\nTelefone: ")
                        .append(f.getTelefone())

                        .append("\nEmail: ")
                        .append(f.getEmail())

                        .append("\n----------------------\n");

            }


            area.setText(sb.toString());


            JOptionPane.showMessageDialog(
                    null,
                    new JScrollPane(area),
                    "Fornecedores cadastrados",
                    JOptionPane.INFORMATION_MESSAGE
            );


        });


    }

}