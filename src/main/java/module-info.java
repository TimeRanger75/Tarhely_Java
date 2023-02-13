module com.example.tarhely {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.tarhely to javafx.fxml, com.google.gson;
    exports com.example.tarhely;
}