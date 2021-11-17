module com.example.javafxgestioninscription {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires sql;


    opens com.example.javafxgestioninscription to javafx.fxml;
    exports com.example.javafxgestioninscription;
    exports com.example.javafxgestioninscription.controleur to javafx.fxml;
    opens com.example.javafxgestioninscription.controleur to javafx.fxml;
    opens com.example.javafxgestioninscription.modele to javafx.base;
}