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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import prettywoman_pjt.model.ClienteDAO;
import prettywoman_pjt.PrettyWoman_pjt;

/**
 * FXML Controller class
 *
 * @author smely
 */
public class CadastraClienteController implements Initializable {
    
    @FXML private Button btn_cancelar;
    @FXML private TextField field_nome;
    @FXML private TextField field_telefone;
    @FXML private TextField field_CPF;
    @FXML private Button btn_adicionarCliente;
    @FXML private TextField field_email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn_adicionarCliente.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                try {
                    cadastrar_cliente();
                } catch (IOException ex) {
                    Logger.getLogger(CadastraClienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });     
    } 
    
    public void cancelar() throws IOException{
        PrettyWoman_pjt.setRoot("view/principal_vendedor");
    }
    
    public void cadastrar_cliente() throws IOException{
        String CPF = field_CPF.getText();
        String nome = field_nome.getText();
        String tel = field_telefone.getText();
        String email = field_email.getText();
        
        ClienteDAO c = new ClienteDAO();

        if(c.adicionaCliente(CPF, nome, email, tel) == true){
            Alert dialogoInfo = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoInfo.setTitle("Mensagem");
                dialogoInfo.setHeaderText("Cliente cadastrado com sucesso!");
                //dialogoInfo.setContentText("Informação importante!");
                dialogoInfo.showAndWait();
                
                PrettyWoman_pjt.setRoot("view/principal_vendedor");
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
