module com.jeprod {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.jeprod to javafx.fxml;
    exports com.jeprod;
}