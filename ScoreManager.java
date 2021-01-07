package Assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreManager {

    public ArrayList<String[]> readScores() {
        ArrayList<String[]> scores;
        try {
            File file = new File(Constants.SCORE_PATH);
            Scanner scan = new Scanner(file);

            scores = new ArrayList<>();

            while (scan.hasNext()) {
                scores.add(scan.next().split(" "));
            }
            return scores;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        ScoreManager score = new ScoreManager();
        score.readScores();
    }
}
