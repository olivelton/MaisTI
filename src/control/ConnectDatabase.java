/*CLASSE DE CONEXÃO COM O BANCO E FECHAMENTO DE CONEXÕES */


package control;

import javax.swing.*;
import java.sql.*;

public class ConnectDatabase {
    private final static String DRIVER = "com.mysql.jdbc.Driver";// carregando o driver do mysql
    private final static String URL = "jdbc:mysql://localhost/maisti";
    private final static String LOGIN = "admin";
    private final static String PASS = "admin";


    //metodo de conexão com o banco
    public  static Connection getConnection(){
        //como trabalha se com banco externo usamos try catch para tratar
        try {
            Class.forName(DRIVER);// chama classe do driver
            return DriverManager.getConnection(URL, LOGIN, PASS); // classe do driver e parametros passados
            // para login no banco de dados.
        }
        catch (ClassNotFoundException  | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Não foi possivel conectar ao banco");
            throw new RuntimeException("erro de conexão com banco: ", ex);//tratamento de erro
            //mostrar para usuario erro erro de conexao e manda a exceção ex


        }

    }

    //metodo para realizar fechamento da conexão
    // sempre bom fechar conexões para não sobrecarregar o banco
    public static void closeConnection(Connection con){
        //usando try catch para tratamento de erros
        try {
            if(con != null) {
            con.close();// se conexão for diferente de null significa que esta aberta conexão e sera fechada
        }

        } catch (SQLException e) {
            //caso haja erro ao fechar conexão enviamos caixa de mensagem e o evento de erro
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"erro ao fechar conexão: "+ e);
        }

    }


    // criamos uma sobrecarga do metodo de fechamento parar tratar fechar  statment
    public static void closeConnection(Connection con, PreparedStatement stat){
        //chamamos o metodo closeconnection e passamos por parametro o con
        closeConnection(con);

        try {
            // se statment for diferente de nullo ele fechara statment
            if(stat != null) stat.close();

        }catch (SQLException a){
            JOptionPane.showMessageDialog(null,"erro ao fechar statment ");

        }


    }

    // criamos uma sobrecarga do metodo de fechamento para tratar fechar result
    public static void closeConnection(Connection con, PreparedStatement stat, ResultSet result){
        //chamamos o metodo closeconnection e passamos por parametro o con e statment
        closeConnection(con, stat);

        try {
            // se result for diferente de nullo ele fechara statment
            if(result != null) result.close();

        }catch (SQLException c){
            JOptionPane.showMessageDialog(null,"erro ao fechar result ");

        }


    }

}
