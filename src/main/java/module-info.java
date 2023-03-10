module com.example.loginpagedb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.loginpagedb to javafx.fxml;
    exports com.example.loginpagedb;
}