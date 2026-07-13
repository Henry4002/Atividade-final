package display;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {

    public Display() {

        setTitle("Sistema de Controle de Estoque");

        setSize(500, 350);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);


        JPanel painel = new JPanel();

        painel.setLayout(new GridLayout(4, 1, 10, 10));

        painel.setBorder(
                BorderFactory.createEmptyBorder(20, 40, 20, 40)
        );


        BotaoArredondado btnFornecedor =
                new BotaoArredondado("Cadastro de Fornecedores");

        BotaoArredondado btnProduto =
                new BotaoArredondado("Cadastro de Produtos");

        BotaoArredondado btnEstoque =
                new BotaoArredondado("Consultar Estoque");

        BotaoArredondado btnTransacoes =
                new BotaoArredondado("Entrada / Saída");


        painel.add(btnFornecedor);
        painel.add(btnProduto);
        painel.add(btnEstoque);
        painel.add(btnTransacoes);


        add(painel);


        btnFornecedor.addActionListener(e -> {
            new FornecedorDisplay().setVisible(true);
        });


        btnProduto.addActionListener(e -> {
            new ProdutoDisplay().setVisible(true);
        });


        btnEstoque.addActionListener(e -> {
            new EstoqueDisplay().setVisible(true);
        });


        btnTransacoes.addActionListener(e -> {
            new TransacoesDisplay().setVisible(true);
        });

    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new Display().setVisible(true);

        });

    }
}