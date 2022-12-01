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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import prettywoman_pjt.model.EstoqueDAO;
import prettywoman_pjt.PrettyWoman_pjt;
import prettywoman_pjt.model.Produto;

/**
 * FXML Controller class
 *
 * @author smely
 */
public class AlterarProdutoController implements Initializable {
    
    public static Produto produto;
    
    @FXML private TextArea area_descricao;
    @FXML private TextField field_nome;
    @FXML private Button btn_alterar;
    @FXML private TextField field_qtd;
    @FXML private TextField field_preco;
    @FXML private ComboBox<String> combo_tipo;
    @FXML private ImageView image_view;
    @FXML private Button btn_seleciona_img;
    @FXML private TextField field_cod;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initProduto();
        
        combo_tipo.getItems().removeAll(combo_tipo.getItems());
        combo_tipo.getItems().addAll("Blusa", "Calca", "Camisa", "Conjunto", "Macacao", "Vestido");
    } 
    
    public void initProduto(){
        field_cod.setText(produto.getCodigoProd());
        field_nome.setText(produto.getNome());
        field_qtd.setText(Integer.toString(produto.getQtd()));
        field_preco.setText(Double.toString(produto.getPreco()));
        combo_tipo.getSelectionModel().select(produto.getTipo());
        area_descricao.setText(produto.getDescricao());
        image_view.setImage(new Image("file:///"+produto.getImagem()));
        
        System.out.printf("%s", produto.getImagem());
    }
    
    public void alterar_produto() throws IOException{
          String codigo = field_cod.getText();
          String nome = field_nome.getText();
          int qtd = Integer.parseInt(field_qtd.getText());
          double preco = Double.parseDouble(field_preco.getText());
          String tipo = combo_tipo.getValue();
          String descricao = area_descricao.getText();
          
          Produto p = new Produto(codigo, nome, qtd, preco, tipo, descricao);
          
          EstoqueDAO e = new EstoqueDAO();
          e.alteraProduto(produto);
          
            if(e.alteraProduto(produto) == true){
               Alert dialogoInfo = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoInfo.setTitle("Mensagem");
                dialogoInfo.setHeaderText("Dados Alterado com sucesso!");
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
    
    public static Produto getProduto() {
        return produto;
    }
    
    public static void setProduto(Produto produto){
        AlterarProdutoController.produto = produto;
    }
    
}
