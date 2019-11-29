package com.jeprod;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class openingPageController {

    @FXML
    private Button primaryButton;

    @FXML
    private void switchToDisplayRooms() throws IOException {
        App.setRoot("displayRooms");
    }
}
