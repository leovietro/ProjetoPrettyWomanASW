package prettywoman_pjt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import prettywoman_pjt.model.BDFabricaConexao;

/**
 *
 * @author smely
 */
public class PrettyWoman_pjt extends Application {
    
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("view/telaInicial"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PrettyWoman_pjt.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
//    private static Scene scene;
//    
//    @Override
//    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//        
//        Scene scene = new Scene(root);
//        
//              
//        stage.setScene(scene);
//        stage.show();
//    }
//    
//    static void setRoot(String fxml) throws IOException {
//        scene.setRoot(loadFXML(fxml));
//    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
        
        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            String sql = "SELECT * FROM vendedor;";
            Statement stm = (Statement) con.createStatement();
            ResultSet rset = stm.executeQuery(sql);

            while (rset.next()) {
                System.out.print(rset.getString("idVendedor") + " - ");
                System.out.println(rset.getString("nome"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PrettyWoman_pjt.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
