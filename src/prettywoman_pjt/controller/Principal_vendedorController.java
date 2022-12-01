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
import javafx.scene.control.Button;
import prettywoman_pjt.PrettyWoman_pjt;

/**
 * FXML Controller class
 *
 * @author smely
 */
public class Principal_vendedorController implements Initializable {
    
    @FXML private Button btn_adicionarCliente;
    @FXML private Button btn_registrarVenda;

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
    
    public void add_cliente()throws IOException {
        PrettyWoman_pjt.setRoot("view/cadastraCliente");
    }
    
    public void registra_venda()throws IOException {
        PrettyWoman_pjt.setRoot("view/registraVenda");
    }
    
}
