package main.java.com.jeprod;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

public class boardController {
    private App app;
    private boolean FlippedCard1 = false, FlippedCard2 = false, FlippedCard3 = false, FlippedCard4 = false, FlippedCard5 = false;
    //    private Card[5] = card information goes here;
    private Game game;

    @FXML
    private Label WinnerLabel;

    @FXML
    private ImageView OpponentCard1;

    @FXML
    private ImageView OpponentCard2;

    @FXML
    private ImageView OpponentCard3;

    @FXML
    private ImageView OpponentCard4;

    @FXML
    private ImageView OpponentCard5;

    @FXML
    private ImageView PlayerCard1;

    @FXML
    private ImageView PlayerCard2;

    @FXML
    private ImageView PlayerCard3;

    @FXML
    private ImageView PlayerCard4;

    @FXML
    private ImageView PlayerCard5;

    @FXML
    private Button RaiseButton;

    @FXML
    private Button CallButton;

    @FXML
    private Button FoldButton;

    @FXML
    private Label Player1ScoreLabel;

    @FXML
    private Label Player2ScoreLabel;

    public boardController() throws IOException {
    }

    @FXML
    void ClickedCard1(MouseEvent event) {
        if(!FlippedCard1){
            PlayerCard1.setImage(new Image ("@../../image/PNG/red_back.png"));
            FlippedCard1 = true;
        }
        else
        {
            PlayerCard1.setImage(new Image("@../../image/PNG/1S.png"));
            FlippedCard1 = false;
        }
    }

    @FXML
    void ClickedCard2(MouseEvent event) {
        if(!FlippedCard2){
            PlayerCard2.setImage(new Image ("@../../image/PNG/red_back.png"));
            FlippedCard2 = true;
        }
        else
        {
            PlayerCard2.setImage(new Image("@../../image/PNG/1S.png"));
            FlippedCard2 = false;
        }
    }

    @FXML
    void ClickedCard3(MouseEvent event) {
        if(!FlippedCard3){
            PlayerCard3.setImage(new Image ("@../../image/PNG/red_back.png"));
            FlippedCard3 = true;
        }
        else
        {
            PlayerCard3.setImage(new Image("@../../image/PNG/1S.png"));
            FlippedCard3 = false;
        }
    }

    @FXML
    void ClickedCard4(MouseEvent event) {
        if(!FlippedCard4){
            PlayerCard4.setImage(new Image ("@../../image/PNG/red_back.png"));
            FlippedCard4 = true;
        }
        else
        {
            PlayerCard4.setImage(new Image("@../../image/PNG/1S.png"));
            FlippedCard4 = false;
        }
    }

    @FXML
    void ClickedCard5(MouseEvent event) {
        if(!FlippedCard5){
            PlayerCard5.setImage(new Image ("@../../image/PNG/red_back.png"));
            FlippedCard5 = true;
        }
        else
        {
            PlayerCard5.setImage(new Image("@../../image/PNG/1S.png"));
            FlippedCard5 = false;
        }
    }

    @FXML
    void PlayerCall(MouseEvent event) {

    }

    @FXML
    void PlayerFold(MouseEvent event) {

    }

    @FXML
    void PlayerRaise(MouseEvent event) {

    }

    @FXML
    public void initialize() throws Exception {
        app = new App();
        app.access();
        String playerId = app.playerId;

        Vector<Card> currentHand = app.dataHandler.getHand(playerId);
        Vector<Card> opponentHand = app.dataHandler.getHand("p1");

        if (playerId.equals("p2")) {
            int[] handValues = app.dataHandler.getHandValues();
            System.out.println("Player 1: " + handValues[0]);
            System.out.println("Player 2: " + handValues[1]);

            if(handValues[0] < 40 && handValues[0] > 20){
                Player1ScoreLabel.setText("Pair");
            } else if(handValues[0] < 60 && handValues[0] > 40){
                Player1ScoreLabel.setText("Two Pair");
            }else if(handValues[0] < 80 && handValues[0] > 60){
                Player1ScoreLabel.setText("Three of a Kind");
            }else if(handValues[0] < 100 && handValues[0] > 80){
                Player1ScoreLabel.setText("Full House");
            }else if(handValues[0] < 120 && handValues[0] > 100){
                Player1ScoreLabel.setText("Four of a Kind");
            }else if(handValues[0] < 140 && handValues[0] > 120){
                Player1ScoreLabel.setText("Straight");
            }else if(handValues[0] < 160 && handValues[0] > 140){
                Player1ScoreLabel.setText("Flush");
            } else {
                Player1ScoreLabel.setText("High Card");
            }

            if(handValues[1] < 40 && handValues[1] > 20){
                Player2ScoreLabel.setText("Pair");
            } else if(handValues[1] < 60 && handValues[1] > 40){
                Player2ScoreLabel.setText("Two Pair");
            }else if(handValues[1] < 80 && handValues[1] > 60){
                Player2ScoreLabel.setText("Three of a Kind");
            }else if(handValues[1] < 100 && handValues[1] > 80){
                Player2ScoreLabel.setText("Full House");
            }else if(handValues[1] < 120 && handValues[1] > 100){
                Player2ScoreLabel.setText("Four of a Kind");
            }else if(handValues[1] < 140 && handValues[1] > 120){
                Player2ScoreLabel.setText("Straight");
            }else if(handValues[1] < 160 && handValues[1] > 140){
                Player2ScoreLabel.setText("Flush");
            } else {
                Player2ScoreLabel.setText("High Card");
            }



            if (handValues[0] > handValues[1]) {
                WinnerLabel.setText("Player 1 wins!");
            }
            else {
                WinnerLabel.setText("Player 2 wins!");
            }

            // Grab p1 cards
            for (int i = 0; i < opponentHand.size(); i++) {
                Card opponentCard = opponentHand.elementAt(i);
                String cardInfo = opponentCard.getValue() + opponentCard.getSuit().toUpperCase();
                if(i == 0)
                    OpponentCard1.setImage(new Image ("@../../image/PNG/" + cardInfo + ".png"));
                if(i == 1)
                    OpponentCard2.setImage(new Image ("@../../image/PNG/" + cardInfo + ".png"));
                if(i == 2)
                    OpponentCard3.setImage(new Image ("@../../image/PNG/" + cardInfo + ".png"));
                if(i == 3)
                    OpponentCard4.setImage(new Image ("@../../image/PNG/" + cardInfo + ".png"));
                if(i == 4)
                    OpponentCard5.setImage(new Image ("@../../image/PNG/" + cardInfo + ".png"));
            }
        }


        for (int i = 0; i < currentHand.size(); i++) {
            Card currentCard = currentHand.elementAt(i);
            String cardInfo = currentCard.getValue() + currentCard.getSuit().toUpperCase();
            if(i == 0)
                PlayerCard1.setImage(new Image ("@../../image/PNG/" + cardInfo + ".png"));
            if(i == 1)
                PlayerCard2.setImage(new Image ("@../../image/PNG/" + cardInfo + ".png"));
            if(i == 2)
                PlayerCard3.setImage(new Image ("@../../image/PNG/" + cardInfo + ".png"));
            if(i == 3)
                PlayerCard4.setImage(new Image ("@../../image/PNG/" + cardInfo + ".png"));
            if(i == 4)
                PlayerCard5.setImage(new Image ("@../../image/PNG/" + cardInfo + ".png"));
        }
    }
}