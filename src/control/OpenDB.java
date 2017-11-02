package control;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.sql.*;

public class OpenDB {
    //armazena userMaisTi do banco de dados
    private String userMaisTi;
    //armazena a senha do banco de dados
    private String passwordMaisTi;
    //recebe o endereco de onde esta o banco de dados
    private String addressBd;
    private String stat = "0";

    //contrutor da classe recebe os dados do banco para acesso
    public OpenDB(String user, String password) {
        this.userMaisTi = user;//carrega usuario do banco vindo da tela de login
        this.passwordMaisTi = password;//carrega senha do banco vindo da tela de login
        this.addressBd = getAddressBd();//carrega endereço do bando atraves do metodo que le um txt
        getConexaoMySQL();
    }


    //vai conferir se esse usuario existe no banco e se este mesmo pode acessar o sistema ou não
    public boolean checkConnection() {

        if (this.stat.equals("1")) return true;
        else {
            return false;
        }
    }


    //metoodo que busca o endereço do banco em um txt database para podermos acessar o banco
    public String getAddressBd() {
        try {//tratamento de erro try
            //instanciamos a classe Scanner para utilizar a entrada do txt
            Scanner scanner = new Scanner(new FileReader("src/resources/database"));
            //utilizando o scanner com while para carregar uma string leitura
            while (scanner.hasNext()) {
                String leitura = scanner.next();
                return leitura;
            }
        }
        //tratando um exceptionpara o caso de erro no arquivo de banco de dados
        catch (IOException e) {
            e.printStackTrace();
            //mensagem para o usuario saber que esta dando erro no arquivo de banco de dados
            JOptionPane.showMessageDialog(null, "erro no arquivo de endereço do banco de dados");
        }
        return "undefined";
    }


//Método de Conexão//

    public java.sql.Connection getConexaoMySQL() {

        Connection connection = null;          //atributo do tipo Connection
       try {
// Carregando o JDBC Driver padrão
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
// Configurando a nossa conexão com um banco de dados//
            String serverName = this.addressBd;    //caminho do servidor do BD
            String mydatabase = "maisti";        //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = this.userMaisTi;        //nome de um usuário de seu BD
            String password = this.passwordMaisTi;      //sua senha de acesso
            connection = DriverManager.getConnection(url, username, password);
            //Testa sua conexão//
            if (connection != null) {
                // status = ("STATUS--->Conectado com sucesso!");
                this.stat = "1";
            } else {
                this.stat = "0";
                //status = ("STATUS--->Não foi possivel realizar conexão");
            }
            return connection;
        } catch (ClassNotFoundException e) {  //Driver não encontrado
            JOptionPane.showMessageDialog(null, "o driver especificado não foi encontrado");
            return null;
        } catch (SQLException e) {
//Não conseguindo se conectar ao banco
           // JOptionPane.showMessageDialog(null, "Erro nos dados... Nao foi possivel conectar ao Banco de Dados.");
            this.stat = "0";
           return null;
        }
    }


    //Método que retorna o status da sua conexão//


    //Método que fecha sua conexão//

   public boolean FecharConexao() {

        try {

            getConexaoMySQL().close();

            return true;

        } catch (SQLException e) {

            return false;

        }



}


    //Método que reinicia sua conexão//




}
