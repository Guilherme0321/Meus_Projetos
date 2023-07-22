package com.lista.listagem;

import javafx.animation.Interpolatable;
import javafx.animation.TranslateTransition;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

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

    private int Aid = 0;

    public void chamar(ActionEvent actionEvent) {

        if (buttonActive) {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.2));
            slide.setNode(add);

            slide.setToX(0);
            slide.play();

            buttonActive = false;
            add.setTranslateX(446);
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

            slide.setToX(446);
            slide.play();
            buttonActive = true;
            add.setTranslateX(0);


            active.setText("Fechar");
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources){
        Tid.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        Tnome.setCellValueFactory(new PropertyValueFactory<User,String>("firstName"));
        Tlastname.setCellValueFactory(new PropertyValueFactory<User,String>("lastName"));
        Temail.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
        Tsenha.setCellValueFactory(new PropertyValueFactory<User,String>("senha"));
        LerSQL getData = new LerSQL();
        ArrayList<User> data = getData.getData("jdbc:mysql://localhost:3306/dados","root","12345");
        addColumnList(data);

        tabela.setOnMouseClicked(event -> {
            User usuario = tabela.getSelectionModel().getSelectedItem();
            if(usuario != null){
                Aid = usuario.getId();
                System.out.println(Aid);
                AfirstName.setText(usuario.getFirstName());
                AlastName.setText(usuario.getLastName());
                Aemail.setText(usuario.getEmail());
                Asenha.setText(usuario.getSenha());
            }
        });
    }

    public void addColumnList(ArrayList<User> data){
        ObservableList<User> userslist = FXCollections.observableArrayList(data);
        tabela.setItems(userslist);
    }


}