/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prettywoman_pjt.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import prettywoman_pjt.model.EstoqueDAO;
import prettywoman_pjt.PrettyWoman_pjt;
import prettywoman_pjt.model.Produto;

/**
 * FXML Controller class
 *
 * @author smely
 */
public class RegistraVendaController implements Initializable {
    
    @FXML private Button btn_cancelar;   
    @FXML private ImageView btn_add;
    @FXML private TextField field_qtd; 
    @FXML private TextField field_codProd;   
    
    @FXML private TableView<Produto> table_venda;
    @FXML private TableColumn<Produto, String> column_prod;
    @FXML private TableColumn<Produto, String> column_qtd;
    @FXML private TableColumn<Produto, String> column_valorT;
    @FXML private TableColumn<Produto, String> column_cod;
    @FXML private TableColumn<Produto, String> column_valorU;
    @FXML private Button btn_continuar;
    
    private String codProd;
    private int qtd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    public void adicionar()throws IOException {
        codProd = field_codProd.getText();
        qtd = Integer.parseInt(field_qtd.getText());
       
        initTable();
    }
    
    public ObservableList<Produto> atualizaTabela(){
        EstoqueDAO e = new EstoqueDAO();
        return FXCollections.observableArrayList(e.getProdutosVenda(codProd, qtd));
    }
    
    public void initTable(){
        column_cod.setCellValueFactory(new PropertyValueFactory("codigoProd"));
        column_qtd.setCellValueFactory(new PropertyValueFactory("qtdVenda"));
        column_prod.setCellValueFactory(new PropertyValueFactory("nome"));
        column_valorU.setCellValueFactory(new PropertyValueFactory("preco"));
        column_valorT.setCellValueFactory(new PropertyValueFactory("valorT"));

        table_venda.setItems(atualizaTabela());   
    }
    
    public void cancelar() throws IOException{
        PrettyWoman_pjt.setRoot("view/principal_vendedor");
    }
    
    public void continuar() throws IOException{
        Produto p = new Produto();
        PrettyWoman_pjt.setRoot("view/finalizaCompra");
    }
    
}
