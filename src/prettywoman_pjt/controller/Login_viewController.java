/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prettywoman_pjt.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
public class Login_viewController implements Initializable {
    
    UsuarioDAO usuario = new UsuarioDAO();
    
    @FXML
    private TextField field_usuario;
    
    @FXML
    private TextField field_senha;
    
    @FXML
    private Button btn_entrar;

    @FXML
    private void return_principal()throws IOException {
        PrettyWoman_pjt.setRoot("view/telaInicial");
    }
    
    @FXML
    private void realiza_login()throws IOException, SQLException {
        String login = field_usuario.getText();
        String senha = field_senha.getText();
        
        usuario.confirmaUsuario(login, senha);
        
        if(usuario.confirmaUsuario(login, senha) == 1){
            PrettyWoman_pjt.setRoot("view/principal_gerente");
        }
        else if(usuario.confirmaUsuario(login, senha) == 2){
            PrettyWoman_pjt.setRoot("view/principal_vendedor");
        }
        else{
            Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
            dialogoInfo.setTitle("Mensagem");
            dialogoInfo.setHeaderText("Usuário Inválido");
            //dialogoInfo.setContentText("Informação importante!");
            dialogoInfo.showAndWait();
            
            field_usuario.setText("");
            field_senha.setText("");
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
