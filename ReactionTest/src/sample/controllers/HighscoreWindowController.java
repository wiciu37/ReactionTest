package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import sample.HighScoreList;
import sample.Score;

import java.net.URL;
import java.util.ResourceBundle;

public class HighscoreWindowController implements Initializable {

    @FXML
    private ListView highScoreListView;

    @FXML
    private Button sortByNickname;

    @FXML
    private Button sortByScoreTime;

    HighScoreList highScoreList;

    public void onSortNicknameClick (MouseEvent mouseEvent)
    {

    }

    public void onSortScoreTimeClick (MouseEvent mouseEvent)
    {

    }

    private ObservableList<Score> scores = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        highScoreList = new HighScoreList();
        highScoreListView.setItems(scores);

        scores.addAll(highScoreList.getScoreList());

    }
}
