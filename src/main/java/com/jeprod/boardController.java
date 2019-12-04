package com.jeprod;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;

public class boardController {
    private boolean FlippedCard1 = false, FlippedCard2 = false, FlippedCard3 = false, FlippedCard4 = false, FlippedCard5 = false;
//    private Card[5] = card information goes here;

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
    private Label Player1MoneyLabel;

    @FXML
    private Label Player2MoneyLabel;

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

}
