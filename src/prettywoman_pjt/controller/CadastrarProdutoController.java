/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prettywoman_pjt.controller;

import java.io.File;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import prettywoman_pjt.model.EstoqueDAO;
import prettywoman_pjt.PrettyWoman_pjt;

/**
 * FXML Controller class
 *
 * @author smely
 */
public class CadastrarProdutoController implements Initializable {
    
    @FXML private TextArea area_descricao;
    @FXML private TextField field_nome;
    @FXML private TextField field_cod;
    @FXML private TextField field_qtd;
    @FXML private TextField field_preco;
    @FXML private Button btn_adicionar;
    @FXML private ComboBox<String> combo_tipo;
    @FXML private ImageView image_view;
    @FXML private Button btn_seleciona_img;
    
    private String caminhoFoto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo_tipo.getItems().removeAll(combo_tipo.getItems());
        combo_tipo.getItems().addAll("Blusa", "Calca", "Camisa", "Conjunto", "Macacao", "Vestido");
        combo_tipo.getSelectionModel().select("Blusa");
        
        btn_seleciona_img.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {              
                    seleciona_imagem();
            }
        });
    }   
    
    public void seleciona_imagem(){
       FileChooser f = new FileChooser(); 
       f.getExtensionFilters().add(new ExtensionFilter("imagens", "*.jpg", "*.png"));
       File file = f.showOpenDialog(new Stage());
       
       if(file != null){
          image_view.setImage(new Image("file:///"+file.getAbsolutePath()));
          caminhoFoto = file.getAbsolutePath();
       }
       
    }
    
    public void add_produto()throws IOException {
        String codigo = field_cod.getText();
        String nome = field_nome.getText();
        int qtd = Integer.parseInt(field_qtd.getText());
        Double preco = Double.parseDouble(field_preco.getText());
        String tipo = combo_tipo.getValue();
        String descricao = area_descricao.getText();
        
        EstoqueDAO e = new EstoqueDAO();
        
        if(e.add_produto(codigo, nome, qtd, preco, tipo, descricao, caminhoFoto) == true){
            Alert dialogoInfo = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoInfo.setTitle("Mensagem");
                dialogoInfo.setHeaderText("Produto Registrado!");
                //dialogoInfo.setContentText("Informação importante!");
                dialogoInfo.showAndWait();
                
                PrettyWoman_pjt.setRoot("view/gerenciaProdutos");
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
