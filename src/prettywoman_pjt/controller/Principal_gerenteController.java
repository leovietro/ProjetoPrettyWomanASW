/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prettywoman_pjt.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import prettywoman_pjt.PrettyWoman_pjt;

/**
 * FXML Controller class
 *
 * @author smely
 */
public class Principal_gerenteController implements Initializable {
    
    @FXML
    private void gerenciar_vendedores()throws IOException {
        PrettyWoman_pjt.setRoot("view/gerenciaVendedores");
    }
    
    @FXML
    private void gerenciar_produtos()throws IOException {
        PrettyWoman_pjt.setRoot("view/gerenciaProdutos");
    }
    
    @FXML
    private void relatorios()throws IOException {
        PrettyWoman_pjt.setRoot("");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void sair()throws IOException {
        PrettyWoman_pjt.setRoot("view/telaInicial");
    }
    
}
