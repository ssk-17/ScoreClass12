package com.test.score;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ScoreClass {

    public static void main(String[] args) throws Exception {

        String filePath = args[0];
        BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));

        //create instance of Chronological sorting.
        ScoringTechnique scoringTechnique = new ChronologicalScoring();

        System.out.println("Score Obtained: " + scoringTechnique.calculateScore(br.readLine()));
    }
}
