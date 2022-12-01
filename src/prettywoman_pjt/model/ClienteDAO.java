/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prettywoman_pjt.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smely
 */
public class ClienteDAO {
    
    public boolean adicionaCliente(String cpf, String nome, String email, String telefone){
        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            String sql = "INSERT INTO cliente(CPF_cliente, nome, email, telefone, vendedor_idVendedor) VALUES('"+cpf+"', '"+nome+"', '"+email+"', '"+telefone+"', 'vd001');";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.execute();       
            return true;
   
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}


