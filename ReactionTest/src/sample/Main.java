package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent playRoot = FXMLLoader.load(getClass().getResource("resources/playWindow.fxml"));
        Scene playScene = new Scene(playRoot, 700, 400);


        primaryStage.setTitle("Reaction Test");
        primaryStage.setScene(playScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
