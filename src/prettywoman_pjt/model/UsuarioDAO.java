/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prettywoman_pjt.model;

//jdbc:mysql://localhost:3306/pretty_woman?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]

import java.sql.Connection;
import java.sql.DriverManager;
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
public class UsuarioDAO {

    public UsuarioDAO() {
        
    }
    
    public int confirmaUsuario(String login, String senha) throws SQLException{
        
        int usuario = 0;
        
        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            String sql_gerente = "SELECT * FROM gerente WHERE idGerente='"+login+"' && senha='"+senha+"';";
            Statement stm = (Statement) con.createStatement();
            ResultSet rset = stm.executeQuery(sql_gerente);

            if(rset.next()) {
                String id = rset.getString("idGerente");
                String nome = rset.getString("nome");
                String senhaG = rset.getString("senha");
                
                Gerente g = new Gerente(nome, id, senhaG);
                
                usuario = 1;
            }
            else{
                String sql_vendedor = "SELECT * FROM vendedor WHERE idVendedor='"+login+"' && senha='"+senha+"';";
                ResultSet rset_vendedor = stm.executeQuery(sql_vendedor);
                
                if(rset_vendedor.next()){
                    usuario = 2;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return usuario;
    }
    
    public List<Vendedor> getVendedor(){
        List<Vendedor> vend = new ArrayList<>();
        
        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            String sql_gerente = "SELECT * FROM vendedor;";
            Statement stm = (Statement) con.createStatement();
            ResultSet rset = stm.executeQuery(sql_gerente);

            while(rset.next()) {
                
                Vendedor v = new Vendedor();
                
                v.setAcesso(rset.getString("idVendedor"));        
                v.setSenha(rset.getString("senha"));
                v.setNome(rset.getString("nome"));
               // String usuarioVendedor = rset.getString("idVendedor");
               // String nomeVendedor = rset.getString("nome");
                
               // Vendedor vendedor = new Vendedor(usuarioVendedor, nomeVendedor);
                vend.add(v);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vend;
    }
    
    public boolean deleteVendedor(Vendedor v){
        
        String id = v.getAcesso();
        
        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            String sql_exclui_vend = "DELETE FROM vendedor WHERE idVendedor='"+id+"';";
            PreparedStatement prep = con.prepareStatement(sql_exclui_vend);
            //prep.setString(1, v.getAcesso());
            prep.execute();
            //stm.executeQuery(sql_exclui_vend);
            
            return true;
   
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean alteraVendedor(Vendedor v){
        
        String nome = v.getNome();
        String senha = v.getSenha();
        String acesso = v.getAcesso();
        
        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            String sql = "UPDATE vendedor SET nome='"+nome+"', senha='"+senha+"' WHERE idVendedor='"+acesso+"';";
            PreparedStatement prep = con.prepareStatement(sql);
            //prep.setString(1, v.getAcesso());
            prep.execute();
            //stm.executeQuery(sql_exclui_vend);
            
            return true;
   
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean adicionaVendedor(String nome, String acesso, String senha){
        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            String sql = "INSERT INTO vendedor(idVendedor, senha, nome) VALUES('"+acesso+"', '"+senha+"', '"+nome+"');";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.execute();       
            return true;
   
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
