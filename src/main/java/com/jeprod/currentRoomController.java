package com.jeprod;

import java.io.IOException;
import javafx.fxml.FXML;

public class currentRoomController {

    @FXML
    private void switchToTitle() throws IOException {
        App.setRoot("openingPage");
    }
}