package com.lista.listagem;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Controller {
    @FXML
    private Button sendRegister;
    @FXML
    private Button active;
    private boolean buttonActive = false;
    @FXML
    private AnchorPane add;

    public void chamar() {

        if (buttonActive) {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.2));
            slide.setNode(add);

            slide.setToX(0);
            slide.play();

            add.setTranslateX(446);
            buttonActive = false;
            System.out.println(buttonActive);
        } else {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.2));
            slide.setNode(add);

            slide.setToX(446);
            slide.play();
            buttonActive = true;
            add.setTranslateX(0);
            System.out.println(buttonActive);
        }
    }
}