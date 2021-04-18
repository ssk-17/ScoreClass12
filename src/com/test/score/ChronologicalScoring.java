package com.test.score;

import java.math.BigInteger;
import java.util.Arrays;

public class ChronologicalScoring implements ScoringTechnique {
    @Override
    public BigInteger calculateScore(String text) {
        if (text == null) return BigInteger.ZERO;

        //using comma as delimiter to retrieve each word
        String[] words = text.split(",");

        //removing quotations from both ends as its not scored
        for (int i = 0; i < words.length; i++)
            words[i] = words[i].substring(1, words[i].length() - 1);

        //Using default sort as it sorts in ascending order
        Arrays.sort(words);

        BigInteger result = BigInteger.ZERO;

        for (int i = 0; i < words.length; i++) {
            BigInteger wordScore = BigInteger.ZERO;

            /*Iterate through each character of word and add relative distance of character with A
              plus 1. resulting in A->1 , B->2, etc.
            */
            for (char ch : words[i].toCharArray())
                wordScore = wordScore.add(BigInteger.valueOf(ch - 'A' + 1));

            //multiply score with index to get the final word score.
            wordScore = wordScore.multiply(BigInteger.valueOf(i + 1));

            //add word score to final result
            result = result.add(wordScore);
        }
        return result;
    }
}
