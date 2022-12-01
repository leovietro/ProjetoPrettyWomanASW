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
import javafx.scene.control.TextField;
import prettywoman_pjt.PrettyWoman_pjt;
import prettywoman_pjt.model.Produto;

/**
 * FXML Controller class
 *
 * @author smely
 */
public class FinalizaCompraController implements Initializable {
    
    @FXML private Button btn_cancelar;
    @FXML private Button btn_continuar;
    
    @FXML private TextField field_cpf;
    @FXML private TextField field_nome;
    @FXML private TextField field_desconto;
    @FXML private TextField field_total;
    
    private double valorT;
    
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Produto p = new Produto();
        
        field_total.setText(Double.toString(valorT));
    }   
    
    public void finalizarVenda()throws IOException{
        
    }
    
    public void cancelar() throws IOException{
        PrettyWoman_pjt.setRoot("view/principal_vendedor");
    }
    
}
