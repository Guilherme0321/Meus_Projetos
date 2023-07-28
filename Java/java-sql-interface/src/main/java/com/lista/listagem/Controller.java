package com.lista.listagem;

import javafx.animation.Interpolatable;
import javafx.animation.TranslateTransition;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.w3c.dom.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Controller implements Initializable {
    @FXML
    private Button sendRegister;
    @FXML
    private Button active;
    private boolean buttonActive = false;
    @FXML
    private AnchorPane add;
    @FXML
    private TableView<User> tabela = new TableView<User>();

    @FXML
    private TableColumn<User, String> Temail = new TableColumn<>();

    @FXML
    private TableColumn<User, Integer> Tid = new TableColumn<>();

    @FXML
    private TableColumn<User, String> Tlastname = new TableColumn<>();

    @FXML
    private TableColumn<User, String> Tnome = new TableColumn<>();

    @FXML
    private TableColumn<User, String> Tsenha = new TableColumn<>();

    @FXML
    private TextField Aemail;

    @FXML
    private TextField AfirstName;

    @FXML
    private TextField AlastName;

    @FXML
    private TextField Asenha;

    @FXML
    private TextField Remail;

    @FXML
    private TextField Rsenha;

    @FXML
    private TextField fistnome;

    @FXML
    private TextField lastnome;

    @FXML
    private TextField deletar;

    ArrayList<User> usuarios;

    private int userLength;
    private int IDdeAlterar;
    private int Aid = 0;

    public void chamar(ActionEvent actionEvent) {

        if (buttonActive) {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.2));
            slide.setNode(add);

            slide.setToX(0);
            slide.play();

            buttonActive = false;
            add.setTranslateX(346);
            slide.setOnFinished((event)->{
                add.setVisible(false);
                add.setDisable(true);
            });
            active.setText("Adicionar");

        } else {
            add.setVisible(true);
            add.setDisable(false);
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.2));
            slide.setNode(add);

            slide.setToX(346);
            slide.play();
            buttonActive = true;
            add.setTranslateX(0);


            active.setText("Fechar");
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources){
        carregarTabela();

        tabela.setOnMouseClicked(event -> {
            User usuario = tabela.getSelectionModel().getSelectedItem();
            if(usuario != null){
                IDdeAlterar = usuario.getId();
                System.out.println(IDdeAlterar);
                AfirstName.setText(usuario.getFirstName());
                AlastName.setText(usuario.getLastName());
                Aemail.setText(usuario.getEmail());
                Asenha.setText(usuario.getSenha());
            }else{
                AfirstName.setText("Vazio");
                AlastName.setText("Vazio");
                Aemail.setText("Vazio");
                Asenha.setText("Vazio");
                IDdeAlterar = -1;
            }
        });
    }

    public void carregarTabela(){
        Tid.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        Tnome.setCellValueFactory(new PropertyValueFactory<User,String>("firstName"));
        Tlastname.setCellValueFactory(new PropertyValueFactory<User,String>("lastName"));
        Temail.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
        Tsenha.setCellValueFactory(new PropertyValueFactory<User,String>("senha"));
        LerSQL getData = new LerSQL("jdbc:mysql://localhost:3306/dados","root","12345");
        ArrayList<User> data = getData.getData();
        usuarios = data;
        addColumnList(data);
    }
    public void addColumnList(ArrayList<User> data){
        ObservableList<User> userslist = FXCollections.observableArrayList(data);
        userLength = data.size();

        tabela.setItems(userslist);
    }
    @FXML
    protected void setData(){
        String nome = fistnome.getText();
        String sobrenome = lastnome.getText();
        String email = Remail.getText();
        String senha = Rsenha.getText();
        if(!nome.isEmpty() && !sobrenome.isEmpty() && !email.isEmpty() && !senha.isEmpty()){
            User newUser = new User(0,nome,sobrenome,email,senha);
            LerSQL set = new LerSQL("jdbc:mysql://localhost:3306/dados","root","12345");
            set.sendData(newUser);
            carregarTabela();
        }
    }

    @FXML
    protected void updateData(){
        if(IDdeAlterar != -1 && !Asenha.getText().isEmpty() && !Aemail.getText().isEmpty() && !AlastName.getText().isEmpty() && !AfirstName.getText().isEmpty()){
            User updatedUser = new User(IDdeAlterar,AfirstName.getText(),AlastName.getText(),Aemail.getText(),Asenha.getText());
            LerSQL update = new LerSQL("jdbc:mysql://localhost:3306/dados","root","12345");
            update.uptade(updatedUser);
            carregarTabela();
        }
    }
    @FXML
    protected void deleteData(){
        String id = deletar.getText();
        boolean isIn = false;
        if(!id.isEmpty()) {
            int ID = Integer.parseInt(id);
            for(User x : usuarios){
                if(ID == x.getId()){
                    isIn = true;
                    break;
                }
            }

            if (isIn && ID > 0) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Aviso!");
                alert.setHeaderText(null);
                alert.setContentText("Deseja excluir essa linha?");

                ButtonType sim = new ButtonType("Sim"), nao = new ButtonType("Não");

                alert.getButtonTypes().setAll(sim, nao);

                alert.showAndWait().ifPresent(res -> {
                    if (res == sim) {
                        LerSQL delete = new LerSQL("jdbc:mysql://localhost:3306/dados", "root", "12345");
                        delete.deleteData(ID);
                        carregarTabela();
                    } else {
                        System.out.println("Ação cancelada!");
                    }
                });
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Aviso!");
                alert.setHeaderText(null);
                alert.setContentText("ID inexistente!");

                alert.showAndWait();
            }
        }
    }


}