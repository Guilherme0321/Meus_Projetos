package com.scenecalculador.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class InterfaceController {
    @FXML
    private TextField tela;
    private String color = "#333;";

    @FXML
    protected void setTela(ActionEvent e){
        String txt = ((Button) e.getSource()).getAccessibleText();
        if(!txt.equals("remove") && !txt.isEmpty()){
            tela.setText(tela.getText() + txt);
        }else if(!tela.getText().isEmpty()){
            StringBuilder strbuilder = new StringBuilder(tela.getText());
            strbuilder.deleteCharAt(strbuilder.length()-1);
            tela.setText(strbuilder.toString());
        }

    }
    @FXML
    protected void changeSinal(ActionEvent e){
        String texto = tela.getText();
        if(!texto.isEmpty() && texto.charAt(0) == '-'){
            texto = texto.substring(1);
        }else{
            texto = "-" + texto;
        }
        tela.setText(texto);
    }
    @FXML
    protected void eraseTela(){
        tela.setText("");
    }
    @FXML
    protected void clickButton(MouseEvent e) {
        Button clicked = (Button) e.getSource();
        color = "#0080ff;";
        clicked.setStyle(clicked.getStyle() + "-fx-background-color: " + color);
    }

    @FXML
    protected void notHoverButton(MouseEvent e) {
        Button clicked = (Button) e.getSource();
        clicked.setStyle(clicked.getStyle().replaceAll("-fx-background-color: " + color, "-fx-background-color: #333;"));
    }
    @FXML
    protected void hover(MouseEvent e){
        Button clicked = (Button) e.getSource();
        color = "#555;";
        clicked.setStyle(clicked.getStyle() + "-fx-background-color: " + color);
    }
}