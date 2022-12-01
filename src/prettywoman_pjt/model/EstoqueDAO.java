/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prettywoman_pjt.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smely
 */
public class EstoqueDAO {
    
    public List<Produto> getProdutos(){
        List<Produto> prod = new ArrayList<>();
        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            String sql_gerente = "SELECT * FROM produto;";
            Statement stm = (Statement) con.createStatement();
            ResultSet rset = stm.executeQuery(sql_gerente);

            while(rset.next()) {
                Produto p = new Produto();
                
                p.setCodigoProd(rset.getString("codigoProduto"));
                p.setNome(rset.getString("nome"));
                p.setQtd(rset.getInt("quantidade"));
                p.setPreco(rset.getDouble("preco"));
                p.setTipo(rset.getString("tipo"));
                p.setDescricao(rset.getString("descricao"));
                p.setImagem(rset.getString("imagem"));
                
                prod.add(p);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prod;
    }
    
    public List<Produto>getProdutosVenda(String cod, int qtd){
        List<Produto> prod = new ArrayList<>();
        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            String sql_gerente = "SELECT * FROM produto WHERE codigoProduto='"+cod+"';";
            Statement stm = (Statement) con.createStatement();
            ResultSet rset = stm.executeQuery(sql_gerente);

            while(rset.next()) {
               Produto p = new Produto();
               
               double precoP = rset.getInt("preco");
                
                p.setCodigoProd(rset.getString("codigoProduto"));
                p.setNome(rset.getString("nome"));
                p.setPreco(rset.getInt("preco"));
                p.setQtdVenda(qtd);
                p.setValorT(qtd * precoP);
               
                prod.add(p);               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prod;
    }
    
    public boolean add_produto(String codigo, String nome, int qtd, Double preco, String tipo, String descricao, String foto){
       try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            String sql = "INSERT INTO produto(codigoProduto, nome, quantidade, preco, tipo, descricao, imagem, Gerente_idGerente) VALUES('"+codigo+"', '"+nome+"', "+qtd+", "+preco+", '"+tipo+"', '"+descricao+"', '"+foto+"', 'gr001');";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.execute();       
            return true;
   
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
     public boolean deleteProd(Produto p){
        
        String codigo = p.getCodigoProd();
        
        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            String sql = "DELETE FROM produto WHERE codigoProduto='"+codigo+"';";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.execute();
            
            return true;
   
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     }
        
    public boolean alteraProduto(Produto p){
        
        String cod = p.getCodigoProd();
        String nome = p.getNome();
        int qtd = p.getQtd();
        double preco = p.getPreco();
        String tipo = p.getTipo();
        String descricao = p.getDescricao();
        
        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            String sql = "UPDATE produto SET nome='"+nome+"', quantidade="+qtd+", preco="+preco+", tipo='"+tipo+"', descricao='"+descricao+"' WHERE codigoProduto='"+cod+"'";
            PreparedStatement prep = con.prepareStatement(sql);
            //prep.setString(1, v.getAcesso());
            prep.execute();
            //stm.executeQuery(sql_exclui_vend);
            
            return true;
   
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }    
}
