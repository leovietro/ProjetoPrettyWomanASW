/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prettywoman_pjt.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import prettywoman_pjt.model.EstoqueDAO;
import prettywoman_pjt.PrettyWoman_pjt;
import prettywoman_pjt.model.Produto;

/**
 * FXML Controller class
 *
 * @author smely
 */
public class GerenciaProdutosController implements Initializable {
    
    @FXML private Button btn_alterar;
    @FXML private Button btn_adicionar;
    @FXML private Button btn_excluir;

    @FXML private TableView<Produto> table_produto;
    @FXML private TableColumn<Produto, String> column_codigo;
    @FXML private TableColumn<Produto, String> column_nome;
    @FXML private TableColumn<Produto, String> column_qtd;
    @FXML private TableColumn<Produto, Double> column_preco;
    @FXML private TableColumn<Produto, String> column_tipo;
    @FXML private TableColumn<Produto, String> column_descricao;
    
    private Produto prodSelecionado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        
        table_produto.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                prodSelecionado = (Produto) newValue;
            }
        });
    }    
    
    public void initTable(){
        column_codigo.setCellValueFactory(new PropertyValueFactory("codigoProd"));
        column_nome.setCellValueFactory(new PropertyValueFactory("nome"));
        column_qtd.setCellValueFactory(new PropertyValueFactory("qtd"));
        column_preco.setCellValueFactory(new PropertyValueFactory("preco"));
        column_tipo.setCellValueFactory(new PropertyValueFactory("tipo"));
        column_descricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        table_produto.setItems(atualizaTabela());   
    }
    
    public ObservableList<Produto> atualizaTabela(){
        EstoqueDAO e = new EstoqueDAO();
        return FXCollections.observableArrayList(e.getProdutos());
    }
    
    public void adicionarProduto()throws IOException {
        PrettyWoman_pjt.setRoot("view/cadastrarProduto");
    }
    
    public void voltar()throws IOException {
        PrettyWoman_pjt.setRoot("view/principal_gerente");
    }
    
    public void alterar_prod() throws IOException{
        if(prodSelecionado != null){
            Produto p = new Produto(prodSelecionado);
            PrettyWoman_pjt.setRoot("view/AlterarProduto");
        }else{
            Alert dialogoInfo = new Alert(Alert.AlertType.WARNING);
            dialogoInfo.setTitle("Mensagem");
            dialogoInfo.setHeaderText("Selecione um produto!");
            //dialogoInfo.setContentText("Informação importante!");
             dialogoInfo.showAndWait();
        }
    }
    
    public void delete_prod()throws IOException {
        if(prodSelecionado != null){
            EstoqueDAO e = new EstoqueDAO();
            e.deleteProd(prodSelecionado);
            
            if(e.deleteProd(prodSelecionado) == true){
                Alert dialogoInfo = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoInfo.setTitle("Mensagem");
                dialogoInfo.setHeaderText("Exclusão Realizada com Sucesso!");
                //dialogoInfo.setContentText("Informação importante!");
                dialogoInfo.showAndWait();
            }
            else{
               Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
               dialogoInfo.setTitle("Mensagem");
               dialogoInfo.setHeaderText("Algo de errado aconteceu!");
               //dialogoInfo.setContentText("Informação importante!");
               dialogoInfo.showAndWait(); 
            }
            
            table_produto.setItems(atualizaTabela());
        }
    }
}
