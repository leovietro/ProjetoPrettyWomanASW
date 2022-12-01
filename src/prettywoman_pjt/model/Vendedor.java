/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prettywoman_pjt.model;

import prettywoman_pjt.controller.AlterarVendedorController;

/**
 *
 * @author smely
 */
public class Vendedor {
    
    private String acesso;
    private String nome;
    private String senha;
    
    public Vendedor(){
        
    }
    
    public Vendedor(String acesso, String nome, String senha){
        this.acesso = acesso;
        this.nome = nome;
        this.senha = senha;
    }
    
    public Vendedor(Vendedor v){
        AlterarVendedorController.setVendedor(v);
    }
    
    public String getNome(){
        return nome;
    }
    
     public String getSenha(){
        return senha;
    }
     
    public String getAcesso(){
        return acesso;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
      
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public void setAcesso(String acesso){
        this.acesso = acesso;
    }
  
}
