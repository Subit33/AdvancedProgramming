package com.example.augustjavafx;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Label loginStatus;
    @FXML
    private RadioButton maleRadio;
    @FXML
    private ChoiceBox<String> countryBox;
    @FXML
    private ImageView userImage;

    String pathToCSV = "src/main/resources/userData.csv";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        countryBox.setItems(FXCollections.observableArrayList("Nepal", "China", "India"));
    }

    @FXML
    public void onClick() {
        String userEmail = email.getText();
        String userPassword = password.getText();
        String gender;
        String selectedCountry = countryBox.getValue();
        if (maleRadio.isSelected()){
            gender = "Male";
        }
        else {
            gender  = "Female";
        }
        loginStatus.setText(userEmail + " " + userPassword + " "
        + gender);
        try {
            FileWriter fileWriter = new FileWriter(pathToCSV, true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            String[] data = {userEmail, userPassword, gender, selectedCountry};
            csvWriter.writeNext(data);
            csvWriter.close();
            loadStage("login-view.fxml");
        }
        catch (Exception e){
            loginStatus.setText(e.getMessage());
        }
    }

    @FXML
    public void uploadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.
                ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));
        File selectedImage = fileChooser.showOpenDialog(null);

        Image image = new Image(selectedImage.toURI().toString());
        userImage.setImage(image);
    }

    @FXML
    public void loadStage(String sceneName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(sceneName));
        Parent loginScene = fxmlLoader.load();
        Stage loginStage = (Stage) loginStatus.getScene().getWindow();
        loginStage.setScene(new Scene(loginScene));
        loginStage.show();
    }
//    @FXML
//    public void loginCheck(){
//        String email = loginEmail.getText();
//        String password = loginPassword.getText();
//
//        try {
//            FileReader fileReader = new FileReader(pathToCSV);
//            CSVReader csvReader = new CSVReader(fileReader);
//            String[] rows;
//
//            while ((rows = csvReader.readNext()) != null){
//                if (email.equals(rows[0]) && password.equals(rows[1])){
//                    loginStatus.setText("Logged In!!!");
//                    break;
//                }
//                else{
//                    loginStatus.setText("Invalid!!!");
//                }
//            }
//
//        }
//        catch (Exception e){
//
//        }
//    }
}