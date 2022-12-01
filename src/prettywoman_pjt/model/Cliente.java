/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author smely
 */
public class Cliente {
    
    private String CPF;
    private String nome;
    private String email;
    private String telefone;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public Cliente(){
        
    }
    
    public Cliente(String cpf, String nome, String email, String telefone){
        this.CPF = CPF;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    
}
