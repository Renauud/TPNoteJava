module com.example.javavraidernierv2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.javavraidernierv2 to javafx.fxml;
    exports com.example.javavraidernierv2;
}