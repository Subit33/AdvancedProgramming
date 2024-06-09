package com.example.aijavafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label myLabel;
    @FXML
    private TextField myTextField;

    @FXML
    public void clicked() {
        String text = myTextField.getText();
        myLabel.setText(text);
    }
}