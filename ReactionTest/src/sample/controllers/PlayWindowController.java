package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.HighScoreList;
import sample.Manual;
import sample.ReactionTest;

import java.awt.*;
import java.io.IOException;

public class PlayWindowController {

    @FXML
    private TextField lastScoreTextField;

    @FXML
    private Button reactionTestButton;

    @FXML
    private Button startPlayingButton;

    @FXML
    private Button pauseGameButton;

    @FXML
    private Button highScoreButton;

    @FXML
    private Button howToPlayButton;

    @FXML
    private Button changeNicknameButton;

    private boolean playing = false;

    private ReactionTest reactionTest = new ReactionTest();
    private HighScoreList highScoreList = new HighScoreList();



    // TODO: 06.09.2020 add code to start the game
    public void startGameOnClick(MouseEvent mouseEvent) {

        startPlayingButton.setDisable(true);
        howToPlayButton.setDisable(true);
        highScoreButton.setDisable(true);
        pauseGameButton.setDisable(false);
        changeNicknameButton.setDisable(true);

        reactionTestButton.setDisable(false);
        reactionTest.startReactionTest();
        System.out.println("the game was started");
    }

    public void changeNicknameOnClick(MouseEvent mouseEvent) {

    }

    public void viewHighScoreOnClick(MouseEvent mouseEvent) {

        openHighScoreWindow();
    }

    public void pauseGameOnClick(MouseEvent mouseEvent) {
        reactionTest.stopReactionTest();
        reactionTestButton.setDisable(true);
        startPlayingButton.setDisable(false);
        howToPlayButton.setDisable(false);
        highScoreButton.setDisable(false);
        pauseGameButton.setDisable(true);
        changeNicknameButton.setDisable(false);

    }

    public void viewHowToPlayOnClick(MouseEvent mouseEvent) {
        Manual.display();
    }


    // TODO: 06.09.2020 button disabled between games, meaning the score wont update if you spam the button after REACT que
    public void onClickReactionButton(MouseEvent mouseEvent) {
        reactionTest.setStopTime(System.currentTimeMillis());
        long result = (reactionTest.getStopTime() - reactionTest.getStartTime());

        lastScoreTextField.setText("Last score: "+result);
        System.out.println("wynik: " + result + " milisekund");
        reactionTest.restartReactionTest();
    }

    private void openHighScoreWindow()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/resources/highscoreWindow.fxml"));

        try {
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Highscore");
            stage.setScene(new Scene(root1));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
