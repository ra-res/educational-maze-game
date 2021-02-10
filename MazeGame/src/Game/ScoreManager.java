package Game;

import Configuration.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreManager {
    ArrayList<Integer> scores = new ArrayList<>();

    /**
     * public ScoreManager() Reads the scores from the file and stores them inside
     * an ArrayList
     */
    public ScoreManager() {
        try {
            File file = new File(Constants.SCORE_PATH);
            Scanner scan = new Scanner(file);
            scores = new ArrayList<>();
            while (scan.hasNext()) {
                scores.add(Integer.parseInt(scan.next()));
            }
            Collections.sort(scores);
        } catch (FileNotFoundException | IllegalArgumentException e) {
            try {
                File newFile = new File(Constants.SCORE_PATH);
                boolean success = newFile.createNewFile();
                if (!success) {
                    throw new IOException("");
                }
            } catch (IOException e1) {
                System.out.println("Unable to configure file!");
                System.exit(0);
            }
        }
    }

    /**
     * ArrayList<Integer> getScores() Getter for the array list
     *
     * @return - array list
     */
    public ArrayList<Integer> getScores() {
        return scores;
    }

    public void addScore(int score) {
        scores.add(score);
        Collections.sort(scores);
    }

    /**
     * void saveScores() Saves to file
     */
    public void saveScores() {
        try {
            Collections.sort(scores);
            PrintWriter pw = new PrintWriter(Constants.SCORE_PATH);
            for (int score : scores) {
                pw.write(String.valueOf(score + "\n"));
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * int[] getTopNScores() Gets the best N scores from the arrayList
     *
     * @param n - how many scores to get
     * @return - int[] with best N scores
     */
    public int[] getTopNScores(int n) {
        if (scores.isEmpty())
            return null;
        if (scores.size() < n)
            n = scores.size();
        int[] topNScores = new int[n];
        for (int i = 0; i < n; i++) {
            topNScores[i] = scores.get(i);
        }
        return topNScores;
    }
}
