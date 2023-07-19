package UserInterface;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Interface_Controller {
    @FXML
    private TextField userName;
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private PasswordField senha;
    @FXML
    private Button cancelar;
    @FXML
    private Button validar;
    @FXML
    private Label alert;
    @FXML
    protected void vallidation(){
        if(userName.getText().isBlank() == false && name.getText().isBlank() == false && email.getText().isBlank() == false && senha.getText().isBlank() == false){
            alert.setText("Enviado");
            alert.setTextFill(Paint.valueOf("lime"));
            iniciazeSending();
        }else{
            alert.setText("Preencha todos os espaços corretamente!");
            alert.setTextFill(Paint.valueOf("red"));
        }
    }
    @FXML
    protected void cancelar(){
        Stage estado = (Stage) cancelar.getScene().getWindow();
        estado.close();;
    }
    public void initialize(){
        name.setOnMouseEntered(event -> name.setStyle(name.getStyle() + "-fx-border-color: blue; -fx-border-width: 0 0 3 0;"));
        name.setOnMouseExited(event -> name.setStyle(name.getStyle() + "-fx-border-color: none; -fx-border-width: 0 0 3 0;"));
        email.setOnMouseEntered(event -> email.setStyle(email.getStyle() + "-fx-border-color: blue; -fx-border-width: 0 0 3 0;"));
        email.setOnMouseExited(event -> email.setStyle(email.getStyle() + "-fx-border-color: none; -fx-border-width: 0 0 3 0;"));
        senha.setOnMouseEntered(event -> senha.setStyle(senha.getStyle() + "-fx-border-color: blue; -fx-border-width: 0 0 3 0;"));
        senha.setOnMouseExited(event -> senha.setStyle(senha.getStyle() + "-fx-border-color: none; -fx-border-width: 0 0 3 0;"));
        userName.setOnMouseEntered(event -> userName.setStyle(userName.getStyle() + "-fx-border-color: blue; -fx-border-width: 0 0 3 0;"));
        userName.setOnMouseExited(event -> userName.setStyle(userName.getStyle() + "-fx-border-color: none; -fx-border-width: 0 0 3 0;"));
    }
    protected void iniciazeSending(){
        User user = new User(userName.getText(), name.getText(),email.getText(),senha.getText());
        sendSQL s = new sendSQL();
        s.send(user);
    }
}