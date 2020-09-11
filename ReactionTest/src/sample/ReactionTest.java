package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.controllers.PlayWindowController;

import java.awt.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class ReactionTest {

    private long startTime;
    private long stopTime;
    private boolean isRunning = false;



    // TODO: 06.09.2020 add changing the colour of the playButton in the run method, mayby sound que as well
    private TimerTask getNewTimerTask()
    {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                setStartTime(System.currentTimeMillis());
                //change sout(react) to button changing colour; reactionTestButton.setStyle("-fx-background-color: RED"); jak to zrobic tutaj
                System.out.println("React");
            }
        };

        return timerTask;

    }

    private Timer timer;

    public ReactionTest(){
    }

    public void startReactionTest()
    {
        if(!isRunning) {
            isRunning = true;
            long reactionTime = Long.MAX_VALUE;

            //random time, before button changes colour and starts measuring reaction time, min 2 sekundy(2000 milisekund)
            final long getReady = (long) (Math.random() * 1000) + 2000;
            timer = new Timer();
            timer.schedule(getNewTimerTask(), getReady);
        }
    }

    // TODO: 06.09.2020 how to stop reaction timer, then restart it, so that after every reactionButton click the game starts again
    public void stopReactionTest()
    {
        if(isRunning)
            timer.cancel();

        isRunning = false;
    }

    public void restartReactionTest()
    {
        stopReactionTest();
        startReactionTest();

    }

    public boolean getIsRunning()
    {
        return isRunning;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStopTime() {
        return stopTime;
    }

    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }

}
