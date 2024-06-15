module com.example.simplecalculator {
    requires javafx.controls;
    requires javafx.fxml;
//    requires jfxrt;
//    requires rt;


    opens com.example.simplecalculator to javafx.fxml;
    exports com.example.simplecalculator;
}