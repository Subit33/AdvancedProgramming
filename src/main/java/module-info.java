module com.example.aijavafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.aijavafx to javafx.fxml;
    exports com.example.aijavafx;
    exports com.example.aijavafx.controller;
    opens com.example.aijavafx.controller to javafx.fxml;
}