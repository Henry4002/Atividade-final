package display;

import dao.TransacoesDAO;
import model.Transacoes;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class TransacoesDisplay extends JFrame {


    private JComboBox<String> cbTipo;
    private JTextField txtQuantidade;
    private JTextField txtProduto;


    public TransacoesDisplay() {


        Estilo.configurarJanela(
                this,
                "Movimentação de Estoque",
                500,
                300
        );


        JPanel painel = new JPanel(
                new GridLayout(4, 2, 15, 15)
        );


        Estilo.configurarPainel(painel);



        // Tipo

        painel.add(
                Estilo.criarLabel("Tipo de movimentação")
        );


        cbTipo = new JComboBox<>();

        cbTipo.addItem("ENTRADA");
        cbTipo.addItem("SAIDA");


        cbTipo.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );


        painel.add(cbTipo);



        // Quantidade

        painel.add(
                Estilo.criarLabel("Quantidade")
        );


        txtQuantidade = new JTextField();

        Estilo.configurarCampo(txtQuantidade);


        painel.add(txtQuantidade);



        // Produto

        painel.add(
                Estilo.criarLabel("ID Produto")
        );


        txtProduto = new JTextField();

        Estilo.configurarCampo(txtProduto);


        painel.add(txtProduto);



        // Botão

        BotaoArredondado btnSalvar =
                new BotaoArredondado("Registrar");


        painel.add(btnSalvar);


        painel.add(new JLabel(""));


        add(painel);



        btnSalvar.addActionListener(e -> {


            try {


                Transacoes t = new Transacoes();



                t.setTipo(
                        cbTipo.getSelectedItem()
                                .toString()
                );



                t.setQuantidade(
                        Integer.parseInt(
                                txtQuantidade.getText()
                        )
                );



                t.setIdProduto(
                        Integer.parseInt(
                                txtProduto.getText()
                        )
                );



                t.setDataHora(
                        LocalDateTime.now()
                );



                boolean sucesso = new TransacoesDAO().realizarTransacao(t);



                if(sucesso){


                    JOptionPane.showMessageDialog(
                            null,
                            "Movimentação registrada com sucesso!"
                    );


                    txtQuantidade.setText("");

                    txtProduto.setText("");


                }else{


                    JOptionPane.showMessageDialog(
                            null,
                            "Erro: quantidade maior que o estoque disponível ou produto inexistente!"
                    );


                }



            } catch(NumberFormatException ex){


                JOptionPane.showMessageDialog(
                        null,
                        "Quantidade e ID do produto devem ser números!"
                );


            }


        });


    }

}