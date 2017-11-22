package modelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import control.ConnectDatabase;
import model.Usuario;

import javax.swing.*;

public class UsuarioDao {

   

    public List<Usuario> consultar(){
        Connection con = ConnectDatabase.getConnection();
        PreparedStatement stat;// cria um statment
        stat = null;//seta null ao statment
        ResultSet result;
        result = null;

        List<Usuario> usuarios = new ArrayList<>();// usuarios do tipo lista recebe uma array list
        //tratamento de erro
        try {
            //atribui query ao statment
            stat = con.prepareStatement("SELECT * FROM tb_usuario");
           //result recebe stat.resultquery que é responsavel por trazer a consulta
            result =  stat.executeQuery();
            // criamos um laço para atribuir os valores vindos da consulta
            while (result.next()){
                // instanciamos objeto usuario
                Usuario user = new Usuario();
                user.setId_user(result.getInt("id_usuario"));//adiciona iduser em model o id user
                user.setNome(result.getString("nome_usuario"));//adiciona nome em model nome user
                user.setSenha(result.getString("senha"));//adiciona senha em model senha user
                usuarios.add(user);//adiciona todos os dados a lista criada acima
            }

            

        }catch (SQLException u){//caso de erro cai no catch e informa usuario com exception
            JOptionPane.showMessageDialog(null," erro ao consultar usuario: "+u);
        }finally {// finaly idependente se de exception ou não
            //vai cair aqui pra finalizar e este finaliza a conexão e o statment
            ConnectDatabase.closeConnection(con, stat, result);

        }
        return usuarios;

    }
    
    public List<Usuario> consultarNome(String nome){
        Connection con = ConnectDatabase.getConnection();
        PreparedStatement stat;// cria um statment
        stat = null;//seta null ao statment
        ResultSet result;
        result = null;

        List<Usuario> usuarios = new ArrayList<>();// usuarios do tipo lista recebe uma array list
        //tratamento de erro
        try {
            //atribui query ao statment
            stat = con.prepareStatement("SELECT * FROM tb_usuario where nome_usuario like ?  ");
           //result recebe stat.resultquery que é responsavel por trazer a consulta
            stat.setString(1, '%' + nome + '%');// segundo campo recebe senha
            result =  stat.executeQuery();
            // criamos um laço para atribuir os valores vindos da consulta
            while (result.next()){
                // instanciamos objeto usuario
                Usuario user = new Usuario();
                user.setId_user(result.getInt("id_usuario"));//adiciona iduser em model o id user
                user.setNome(result.getString("nome_usuario"));//adiciona nome em model nome user
                user.setSenha(result.getString("senha"));//adiciona senha em model senha user
                usuarios.add(user);//adiciona todos os dados a lista criada acima
            }

            

        }catch (SQLException u){//caso de erro cai no catch e informa usuario com exception
            JOptionPane.showMessageDialog(null," erro ao consultar usuario: "+u);
        }finally {// finaly idependente se de exception ou não
            //vai cair aqui pra finalizar e este finaliza a conexão e o statment
            ConnectDatabase.closeConnection(con, stat, result);

        }
        return usuarios;

    }
    

    public boolean checkLogin(String login, String senha){
        Connection con = ConnectDatabase.getConnection();
        PreparedStatement stat;// cria um statment
        stat = null;//seta null ao statment
        ResultSet result;
        result = null;
        boolean check = false;


        //tratamento de erro
        try {
            //atribui query ao statment
            stat = con.prepareStatement("SELECT * FROM tb_usuario where nome_usuario = ? AND senha = ?");
            stat.setString(1, login);//primeiro campo recebe login
            stat.setString(2, senha);// segundo campo recebe senha
            //result recebe stat.resultquery que é responsavel por trazer a consulta
            result =  stat.executeQuery();
            // criamos um if para realizar a validação de usuarios
            if(result.next()){
                check = true;
            }


        }catch (SQLException u){//caso de erro cai no catch e informa usuario com exception
            JOptionPane.showMessageDialog(null," erro ao consultar usuario: "+u);
        }finally {// finaly idependente se de exception ou não
            //vai cair aqui pra finalizar e este finaliza a conexão e o statment
            ConnectDatabase.closeConnection(con, stat, result);

        }
        return check;

    }
    
    public void novoUsuario(String nome, String senha) {
    	 Connection con = ConnectDatabase.getConnection();
         PreparedStatement stat;// cria um statment
         stat = null;//seta null ao statment
       
        


         //tratamento de erro
         try {
             //atribui query ao statment
        	 
             stat = con.prepareStatement("INSERT INTO tb_usuario (nome_usuario, senha) VALUES(?, ?)");
             stat.setString(1, nome);//primeiro campo recebe login
             stat.setString(2, senha);// segundo campo recebe senha
            
            stat.execute();
             
             JOptionPane.showMessageDialog(null, "Usuario Cadastrado com Sucesso");


         }catch (SQLException u){//caso de erro cai no catch e informa usuario com exception
             JOptionPane.showMessageDialog(null," erro ao Cadastrar usuario: "+u);
         }finally {// finaly idependente se de exception ou não
             //vai cair aqui pra finalizar e este finaliza a conexão e o statment
             ConnectDatabase.closeConnection(con, stat);

         }
         
    	
    }

    public void editaUsuario(int id, String nome, String senha) {
   	 Connection con = ConnectDatabase.getConnection();
     PreparedStatement stat;// cria um statment
     stat = null;//seta null ao statment
   
    


     //tratamento de erro
     try {
         //atribui query ao statment
    	
         stat = con.prepareStatement("update tb_usuario set nome_usuario = ?, senha = ? Where id_usuario = ?");
         stat.setString(1, nome);//primeiro campo recebe login
         stat.setString(2, senha);// segundo campo recebe senha
         stat.setInt(3, id);
        stat.executeUpdate();
         JOptionPane.showMessageDialog(null, "Usuario: " + nome + " editado com sucesso");


     }catch (SQLException u){//caso de erro cai no catch e informa usuario com exception
         JOptionPane.showMessageDialog(null," erro ao Cadastrar usuario: "+u);
     }finally {// finaly idependente se de exception ou não
         //vai cair aqui pra finalizar e este finaliza a conexão e o statment
         ConnectDatabase.closeConnection(con, stat);

     }
     
    	
    }
    
    public void excluirUsuario(int id) {
    	  
    	    	 Connection con = ConnectDatabase.getConnection();
    	         PreparedStatement stat;// cria um statment
    	         stat = null;//seta null ao statment
    	       
    	        


    	         //tratamento de erro
    	         try {
    	             //atribui query ao statment
    	        	 
    	             stat = con.prepareStatement("DELETE FROM tb_usuario where id_usuario = ? ");
    	             stat.setInt(1, id);
    	                 	            
    	             stat.execute();
    	             
    	             JOptionPane.showMessageDialog(null, "Usuario deletado com Sucesso");


    	         }catch (SQLException u){//caso de erro cai no catch e informa usuario com exception
    	             JOptionPane.showMessageDialog(null," erro ao Deletar usuario: "+u);
    	         }finally {// finaly idependente se de exception ou não
    	             //vai cair aqui pra finalizar e este finaliza a conexão e o statment
    	             ConnectDatabase.closeConnection(con, stat);

    	         }
    	         
    	    	
    	    

    }
}
