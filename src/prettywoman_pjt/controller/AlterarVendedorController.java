/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prettywoman_pjt.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import prettywoman_pjt.PrettyWoman_pjt;
import prettywoman_pjt.model.UsuarioDAO;
import prettywoman_pjt.model.Vendedor;

/**
 * FXML Controller class
 *
 * @author smely
 */
public class AlterarVendedorController implements Initializable {
    
    @FXML private TextField field_nome;
    @FXML private TextField field_acesso;
    @FXML private TextField field_senha;
    @FXML private Button btn_alterar;
    @FXML private Button btn_cancelar;
    private static Vendedor vendedor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initVendedor();
        
        btn_alterar.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                try {
                    alterarVendedor();
                } catch (IOException ex) {
                    Logger.getLogger(AlterarVendedorController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void alterarVendedor() throws IOException{
        String nome = field_nome.getText();
        String senha = field_senha.getText();
        String acesso = field_acesso.getText();
        
        Vendedor v = new Vendedor(acesso, nome, senha);
        
        UsuarioDAO user = new UsuarioDAO();
        
        user.alteraVendedor(v);
        
        if(user.alteraVendedor(v) == true){
            Alert dialogoInfo = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoInfo.setTitle("Mensagem");
                dialogoInfo.setHeaderText("Dados Alterado com sucesso!");
                //dialogoInfo.setContentText("Informação importante!");
                dialogoInfo.showAndWait();
                
                PrettyWoman_pjt.setRoot("view/gerenciaVendedores");
        }
        else{
            Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
            dialogoInfo.setTitle("Mensagem");
            dialogoInfo.setHeaderText("Algo de errado aconteceu!");
            //dialogoInfo.setContentText("Informação importante!");
            dialogoInfo.showAndWait(); 
        }
    }
    
    public void initVendedor(){
        field_nome.setText(vendedor.getNome());
        field_acesso.setText(vendedor.getAcesso());
        field_senha.setText(vendedor.getSenha());
    }
    
    public static Vendedor getVendedor(){
        return vendedor;
    }
    
    public static void setVendedor(Vendedor vendedor){
        AlterarVendedorController.vendedor = vendedor;
    }
}
