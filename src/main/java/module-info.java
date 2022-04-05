module com.example.coffeeshop {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.coffeeshop to javafx.fxml;
    opens com.example.coffeeshop.Controller to javafx.fxml;
    opens com.example.coffeeshop.models to javafx.fxml;
    
    exports com.example.coffeeshop;
    exports com.example.coffeeshop.Controller;
    exports com.example.coffeeshop.models;
}
