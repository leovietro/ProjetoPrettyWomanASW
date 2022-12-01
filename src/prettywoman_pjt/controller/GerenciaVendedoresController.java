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
import prettywoman_pjt.PrettyWoman_pjt;
import prettywoman_pjt.model.UsuarioDAO;
import prettywoman_pjt.model.Vendedor;
import prettywoman_pjt.model.Vendedor;

/**
 * FXML Controller class
 *
 * @author smely
 */
public class GerenciaVendedoresController implements Initializable {
    
   @FXML
    private Button btn_iniciar1;

    @FXML
    private Button btn_iniciar2;

    @FXML
    private Button btn_iniciar;

    @FXML
    private TableView<Vendedor> table_vendedor;
    
    @FXML
    private TableColumn<Vendedor, String> column_nome;
    
    @FXML
    private TableColumn<Vendedor, String> column_usuario;
    private Vendedor vendSelecionado;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        
        table_vendedor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                vendSelecionado = (Vendedor) newValue;
            }
        });
    }   
    
    public void initTable(){
        column_nome.setCellValueFactory(new PropertyValueFactory("nome"));
        column_usuario.setCellValueFactory(new PropertyValueFactory("acesso"));
        table_vendedor.setItems(atualizaTabela());   
    }
    
    public ObservableList<Vendedor> atualizaTabela(){
        UsuarioDAO usuarioDao = new UsuarioDAO();
        return FXCollections.observableArrayList(usuarioDao.getVendedor());
    }
    
    public void delete_vend()throws IOException {
        if(vendSelecionado != null){
            UsuarioDAO dao = new UsuarioDAO();
            dao.deleteVendedor(vendSelecionado);
            
            if(dao.deleteVendedor(vendSelecionado) == true){
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
            
            table_vendedor.setItems(atualizaTabela());
        }
    }
    
    public void adicionar_vend()throws IOException {
        PrettyWoman_pjt.setRoot("view/cadastroVendedor");
    }
    
    public void voltar()throws IOException {
        PrettyWoman_pjt.setRoot("view/principal_gerente");
    }
    
    public void alterar_vendedor()throws IOException {
        if(vendSelecionado != null){
            Vendedor v = new Vendedor(vendSelecionado);
            PrettyWoman_pjt.setRoot("view/alterarVendedor");
        }else{
            Alert dialogoInfo = new Alert(Alert.AlertType.WARNING);
            dialogoInfo.setTitle("Mensagem");
            dialogoInfo.setHeaderText("Selecione um usuário!");
            //dialogoInfo.setContentText("Informação importante!");
             dialogoInfo.showAndWait();
        }
    }
    
}
