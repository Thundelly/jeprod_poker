package main.java.com.jeprod;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class openingPageController {

    /*
    Simply moves between the room selector and the title page
     */

    @FXML
    private Button primaryButton;

    @FXML
    private void switchToDisplayRooms() throws IOException {
        Main.setRoot("displayRooms");
    }
}
