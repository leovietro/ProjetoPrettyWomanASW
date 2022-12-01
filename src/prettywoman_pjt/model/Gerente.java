/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prettywoman_pjt.model;

/**
 *
 * @author smely
 */
public class Gerente {
    private String nome;
    private String acesso;
    private String senha;
    
    public Gerente(String nome, String acesso, String senha){
        this.nome = nome;
        this.acesso = acesso;
        this.senha = senha;
    }
    
    public Gerente(){
        
    }
    
    public String getNome(String nome){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getAcesso(String acesso){
        return acesso;
    }
    
    public void setAcesso(String acesso){
        this.acesso = acesso;
    }
    
    public String getSenha(String senha){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
}
