/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prettywoman_pjt.model;

import prettywoman_pjt.controller.AlterarProdutoController;

/**
 *
 * @author smely
 */
public class Produto {
    private String codigoProd;
    private String nome;
    private int qtd;
    private double preco;
    private String tipo;
    private String descricao;
    private String idGerente;
    private String imagem;
    
    private int qtdVenda;

    public int getQtdVenda() {
        return qtdVenda;
    }

    public void setQtdVenda(int qtdVenda) {
        this.qtdVenda = qtdVenda;
    }

    public double getValorT() {
        return valorT;
    }

    public void setValorT(double valorT) {
        this.valorT = valorT;
    }
    private double valorT;
    
    public Produto(String codigoProd, String nome, int qtd, double preco, String tipo, String descricao){
       this.codigoProd = codigoProd;
       this.nome = nome;
       this.qtd = qtd;
       this.preco = preco;
       this.tipo = tipo;
       this.descricao = descricao;
    }
    
    public Produto(){
        
    }
    
    public Produto(Produto p){
        AlterarProdutoController.setProduto(p);
    }
    
    public Produto(String codigoProd, String nome, double preco){
       this.codigoProd = codigoProd;
       this.nome = nome;
       this.preco = preco;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getCodigoProd() {
        return codigoProd;
    }

    public void setCodigoProd(String codigoProd) {
        this.codigoProd = codigoProd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(String idGerente) {
        this.idGerente = "gr001";
    }
    
    
}
