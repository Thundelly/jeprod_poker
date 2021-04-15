package main.java.com.jeprod;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * JavaFX App
 */
public class Main extends Application {

    /*
    The main class that controls the Stage of the GUI
    The stage gets filled with Scenes that display the FXML files
     */
    private static Stage stage;
    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        scene = new Scene(loadFXML("board"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        /* Changed this method to load AND resize Scene
         */
        stage.getScene().setRoot(loadFXML(fxml));
        stage.sizeToScene();
        stage.setResizable(false);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(new File("/Users/eric/OneDrive/College/PCC/CS_03B/project/Poker2/src/main/resources/com/jeprod/board.fxml").toURI().toURL());
        return fxmlLoader.load();
    }


    public static void main(String[] args) throws Exception {
        launch();
    }

}