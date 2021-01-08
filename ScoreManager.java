package Assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreManager {
    ArrayList<Integer> scores = new ArrayList<>();

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
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public void addScore(int score) {
        scores.add(score);
        Collections.sort(scores);
    }

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

    public int[] getTopNScores(int n) {
        if (scores.isEmpty()) return null;
        if (scores.size() < n) n = scores.size();
        int[] topNScores = new int[n];
        for (int i = 0; i < n; i++) {
            topNScores[i] = scores.get(scores.size() - 1 - i);
        }
        return topNScores;
    }


    public static void main(String[] args) {
        ScoreManager score = new ScoreManager();
        int[] a = score.getTopNScores(5);

        for (int aa : a) {
            System.out.println(aa);
        }
        score.saveScores();
    }
}
