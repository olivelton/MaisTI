package control;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;


public class OpenDB {
    private String user;
    private String password;
    private String addressBd;
//contrutor da classe recebe os dados do banco para acesso
    public OpenDB(String user, String password) {
        this.user = user;
        this.password = password;
        this.addressBd = getAddressBd();
        System.out.println(this.addressBd);
    }


//vai conferir se esse usuario existe no banco e se este mesmo pode acessar o sistema ou não
    public boolean checkConnection(){

        if(this.user.equals("Olivelton") && this.password.equals("123")) return true;
        else{
            return false;
        }
        }

        public String getAddressBd(){
            try{
                Scanner scanner = new Scanner(new FileReader("src/resources/database"));
                while (scanner.hasNext()) {
                    String leitura = scanner.next();
                    return leitura;
                }}
            catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "erro no arquivo de endereço do banco de dados");
            }
           return "undefined";
        }



}
