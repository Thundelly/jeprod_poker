package main.java.com.jeprod;

import java.io.IOException;
import javafx.fxml.FXML;

public class currentRoomController {

    @FXML
    private void switchToTitle() throws IOException {
        Main.setRoot("openingPage");
    }
}