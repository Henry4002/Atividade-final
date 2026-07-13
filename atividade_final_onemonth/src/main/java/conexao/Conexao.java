package conexao;

import javax.print.MultiDocPrintService;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/atividade_final";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection conectar() {

        try {

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}