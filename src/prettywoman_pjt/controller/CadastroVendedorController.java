/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prettywoman_pjt.controller;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
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

/**
 * FXML Controller class
 *
 * @author smely
 */
public class CadastroVendedorController implements Initializable {
    
    @FXML private TextField field_nome;
    @FXML private TextField field_acesso;
    @FXML private TextField field_senha;
    @FXML private Button btn_cadastrar;
    @FXML private Button btn_cancelar;
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           btn_cadastrar.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                try {
                    cadastrar_vendedor();
                } catch (IOException ex) {
                    Logger.getLogger(CadastroVendedorController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void cancelar_cadastro()throws IOException {
        PrettyWoman_pjt.setRoot("view/gerenciaVendedores");
    }
    
    public void cadastrar_vendedor() throws IOException{
        String nome = field_nome.getText();
        String acesso = field_acesso.getText();
        String senha = field_senha.getText();
        
        UsuarioDAO usuario = new UsuarioDAO();

        if(usuario.adicionaVendedor(nome, acesso, senha) == true){
            Alert dialogoInfo = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoInfo.setTitle("Mensagem");
                dialogoInfo.setHeaderText("Vendedor Registrado!");
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
    
}
