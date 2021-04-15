package main.java.com.jeprod;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class displayRoomsController {

    @FXML
    private AnchorPane SecondAnchorPane;

    @FXML
    private Button buttonJoinRoom1;

    @FXML
    private Button buttonReturnToTitle;

    @FXML
    private Button buttonJoinRoom2;

    @FXML
    private Button buttonJoinRoom4;

    @FXML
    private Button buttonJoinRoom3;

    @FXML
    private void switchToCurrentRoom() throws IOException {
        Main.setRoot("currentRoom");
    }

}