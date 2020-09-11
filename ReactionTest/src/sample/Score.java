package sample;

import java.util.Comparator;
import java.util.Objects;

public class Score {

    private String nickname;
    private long time;

    public Score(String nickname, long score)
    {
        this.nickname = nickname;
        this.time = score;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getTime() {
        return time;
    }

    public void setScore(long score) {
        this.time = score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, nickname);
    }

    @Override
    public boolean equals(Object obj) {
        if( obj == this) return true;

        if(!(obj instanceof Score)) return false;

        Score s = (Score) obj;

        return time == s.time && Objects.equals(nickname, s.nickname);
    }

    public static Comparator<Score> scoreTimeComparator = new Comparator<Score>() {
        @Override
        public int compare(Score s1, Score s2) {

            if(s1.getTime() == s2.getTime()) return 0;
            if(s1.getTime() > s2.getTime()) return 1;
            if(s1.getTime() < s2.getTime()) return -1;

            return 0;
            //return (int) (s2.getTime() - s1.getTime());
        }
    };

    public static Comparator<Score> nicknameComparator = new Comparator<Score>() {
        @Override
        public int compare(Score s1, Score s2) {
            return s1.getNickname().compareTo(s2.getNickname());
        }
    };
    public String toString()
    {
        return nickname +" - " + time;
    }
}
