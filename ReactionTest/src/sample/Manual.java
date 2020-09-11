package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Manual {


    //make a method for each label?
    public static void display() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Manual for reaction test game");

        window.setMinWidth(250);

        Label label1 = new Label();
        label1.setText("This is a manual for reaction test game");

        Label startPlayingLabel = new Label();
        startPlayingLabel.setText("Start playing - starts the game. You have to wait between 2-12 seconds after pressing it for the 'Click me' button to change colour, then click it as soon as it changes.");

        Label pauseTheGameLabel = new Label();
        pauseTheGameLabel.setText("Pause the game - pauses the game untill you press 'start playing'");

        Label changeNickNameLabel = new Label();
        changeNickNameLabel.setText("Change Nickname - opens new windows with field to enter nickname under which you want your scores to be saved for the future");

        Label highScoreLabel = new Label();
        highScoreLabel.setText("Highscore - opens list with all the scores from previous games, you can sort it by nickname or score");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1, startPlayingLabel, pauseTheGameLabel, changeNickNameLabel, highScoreLabel);
        layout.setAlignment(Pos.BASELINE_LEFT);

        Scene scene = new Scene(layout, 900, 400);
        window.setScene(scene);

        window.showAndWait();

    }

}
