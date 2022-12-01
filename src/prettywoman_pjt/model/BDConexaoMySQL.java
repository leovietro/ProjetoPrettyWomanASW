package prettywoman_pjt.model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import prettywoman_pjt.model.BDConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author everton
 */
public class BDConexaoMySQL extends BDConexao {    
    
    public BDConexaoMySQL() {
        
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.porta = 3306;
        this.servidor = "localhost";
        this.bd = "pretty_woman";
        this.usuario = "root";
        this.senha = "";
    }

    @Override
    public Connection getConnection() {
        
        try {           
            Class.forName(driver);
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection(getURL(), usuario, senha);

        } catch (SQLException ex) {
            Logger.getLogger(BDConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO CARREGAR DRIVE");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;

    }

    @Override
    public String getURL() {
        return "jdbc:mysql://" + this.servidor + ":" + this.porta + "/" + this.bd 
                + "?useTimezone=true&serverTimezone=UTC";
    }

}
