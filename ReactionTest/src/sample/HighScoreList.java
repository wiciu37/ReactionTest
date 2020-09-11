package sample;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HighScoreList {

    private List<Score> scoreList;
    private static final File highScoreFile = new File("C:\\Users\\Pc\\IdeaProjects\\ReactionTest\\src\\sample\\HighScoreFile.txt");

    /*
    public static void main(String[] args) {
        HighScoreList highScoreList = new HighScoreList();
        highScoreList.addScoreToList(new Score("www", 37777));
        highScoreList.addScoreToList(new Score("w", 37));
        highScoreList.addScoreToList(new Score("aaa", 37777));
        highScoreList.addScoreToList(new Score("a", 37777));
        highScoreList.addScoreToList(new Score("cccc", 3234));
        highScoreList.writeToHighScoreFile();

    }
*/




    public HighScoreList() {
        loadScoreListFromFile();

    }

    public void loadScoreListFromFile()
    {
        List<String> tmp = new ArrayList();
        try{
            tmp = FileUtils.readLines(highScoreFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        scoreList = new ArrayList<>();

        String[] line;
        String tmpUser;
        long tmpTime;

        for(int i = 0;i<tmp.size();i++)
        {
            line = tmp.get(i).split(":");
            tmpUser = line[0];
            tmpTime = Long.parseLong(line[1]);

            scoreList.add(new Score(tmpUser, tmpTime));
        }
    }

    public void addScoreToList(Score score)
    {
        if(!scoreList.contains(score))
            scoreList.add(score);
    }

    public void writeToHighScoreFile()
    {
        StringBuffer sb = new StringBuffer();
        for(Score score : scoreList)
            sb.append(score.getNickname()+":"+score.getTime()+System.lineSeparator());


        try {
            FileUtils.writeStringToFile(highScoreFile, sb.toString(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    // TODO: 06.09.2020 ask, if the sort methods should return List or be void 
    public static void sortByHighscore(List<Score> scoreList1)
    {
        //List<Score> returnList = new ArrayList<>(scoreList);
        Collections.sort(scoreList1, Score.scoreTimeComparator);
        
        //return returnList;
    }

    public static void sortByNickname(List<Score> scoreList1)
    {
        //List<Score> returnList = new ArrayList<>(scoreList);
        Collections.sort(scoreList1, Score.nicknameComparator);
    }

    public List<Score> getScoreList()
    {
        return scoreList;
    }


}
