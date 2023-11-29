module com.rummikubphase2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.rummikubphase2 to javafx.fxml;
    exports com.rummikubphase2;
    //opens com.rummikubphase2.View to javafx.fxml;
}