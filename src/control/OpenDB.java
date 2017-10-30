package control;

import javax.swing.*;

public class OpenDB {
    private String user;
    private String password;
//contrutor da classe recebe os dados do banco para acesso
    public OpenDB(String user, String password){
        this.user = user;
        this.password = password;
        JOptionPane.showMessageDialog(null, "usuario e senha é " + this.user + " " + this.password);
    }
//vai conferir se esse usuario existe no banco e se este mesmo pode acessar o sistema ou não
    public boolean checkConnection(){
        if(this.user.equals("Olivelton") && this.password.equals("123")) return true;
        else{
            return false;
        }
        }


}
