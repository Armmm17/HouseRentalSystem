module com.armmm17.houserentalsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.armmm17.houserentalsystem to javafx.fxml;
    exports com.armmm17.houserentalsystem;
}