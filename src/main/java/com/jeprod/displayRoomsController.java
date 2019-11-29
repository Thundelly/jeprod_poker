package com.jeprod;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class displayRoomsController {

    @FXML
    private Button secondaryButton;

    @FXML
    private void switchToCurrentRoom() throws IOException {
        App.setRoot("tertiary");
    }

}