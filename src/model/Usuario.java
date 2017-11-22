package model;

import modelDao.UsuarioDao;

public class Usuario {
    private int id_user;
    private String nome;
    private String senha;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    public void cadastraUsuarioBanco() {
    	new UsuarioDao().novoUsuario(this.nome, this.senha);
    }
    
    public void consultaUsuario() {
    new UsuarioDao().consultar();
    }

    
    public void deletarUsuario() {
    	
    	new UsuarioDao().excluirUsuario(getId_user());
    	
    }
    
    public void editarUsuario(int id_usuario) {
    	new UsuarioDao().editaUsuario(id_usuario, nome, senha);
    }
}
