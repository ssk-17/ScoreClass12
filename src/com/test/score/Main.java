package com.test.score;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws Exception {

        String filePath = args[0];
        BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));

        //create instance of IndexScoring
        ScoringTechnique scoringTechnique = new IndexScoring();

        System.out.println("Index Based scoring: " + scoringTechnique.findScore(br.readLine()));
    }
}
