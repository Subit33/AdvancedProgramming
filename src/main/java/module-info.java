module com.example.augustjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires opencsv;

    opens com.example.augustjavafx to javafx.fxml;
    exports com.example.augustjavafx;
}