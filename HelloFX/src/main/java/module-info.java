module org.example.hellofx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.hellofx to javafx.fxml;
    exports org.example.hellofx;
}