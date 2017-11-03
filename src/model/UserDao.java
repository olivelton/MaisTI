package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import control.ConnectDatabase;

import javax.swing.*;

public class UserDao {

    public void create(User user) {
        //chamamos a conexão com o banco
        Connection con = ConnectDatabase.getConnection();
        PreparedStatement stat;// cria um statment
        stat = null;//seta null ao statment
        //tratamento de erro
        try {
            //atribui query ao statment
        stat = con.prepareStatement("insert in to tb_usuario (nome_usuario, senha)values(?, ?)");
        // diz que na posição 1 de valores vai buscar get nome do usuario
        stat.setString(1,user.getNome());
        //diz que na posição 2 dos valores da query vai busca a senha do usuario
        stat.setString(2,user.getSenha());
        //responsavel pela sql exception pela dml do mysql
        stat.executeUpdate();

        JOptionPane.showMessageDialog(null,"cadastrado com suscesso");

        }catch (SQLException u){//caso de erro cai no catch e informa usuario com exception
            JOptionPane.showMessageDialog(null," erro ao cadastrar usuario: "+u);
        }finally {// finaly idependente se de exception ou não
            //vai cair aqui pra finalizar e este finaliza a conexão e o statment
            ConnectDatabase.closeConnection(con, stat);
        }
    }

    public List<User> read(){
        Connection con = ConnectDatabase.getConnection();
        PreparedStatement stat;// cria um statment
        stat = null;//seta null ao statment
        ResultSet result;
        result = null;

        List<User> usuarios = new ArrayList<>();// usuarios do tipo lista recebe uma array list
        //tratamento de erro
        try {
            //atribui query ao statment
            stat = con.prepareStatement("SELECT * FROM tb_usuario");
           //result recebe stat.resultquery que é responsavel por trazer a consulta
            result =  stat.executeQuery();
            // criamos um laço para atribuir os valores vindos da consulta
            while (result.next()){
                // instanciamos objeto usuario
                User user = new User();
                user.setId_user(result.getInt("id_usuario"));//adiciona iduser em model o id user
                user.setNome(result.getString("nome_usuario"));//adiciona nome em model nome user
                user.setSenha(result.getString("senha"));//adiciona senha em model senha user
                usuarios.add(user);//adiciona todos os dados a lista criada acima
            }

            JOptionPane.showMessageDialog(null,"cadastrado com suscesso");

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


}
