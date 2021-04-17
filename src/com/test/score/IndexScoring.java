package com.test.score;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class IndexScoring implements ScoringTechnique {
    @Override
    public BigInteger findScore(String text) {
        if (text == null) return BigInteger.ZERO;

        String[] words = text.split(",");

        for (int i = 0; i < words.length; i++) {
            //refine each word by removing quotations from both ends.
            words[i] = words[i].substring(1, words[i].length() - 1);
        }

        Arrays.sort(words);
        BigInteger result = BigInteger.ZERO;

        for (int i = 0; i < words.length; i++) {
            BigInteger wordScore = BigInteger.ZERO;

            /*Iterate through each character of word and add relative distance of character with A
              plus 1. resulting in A->1 , B->2, etc.
            */
            for (char ch : words[i].toCharArray()) {
                wordScore = wordScore.add(BigInteger.valueOf(ch - 'A' + 1));
            }

            //multiply obtained score with index to get the final word score.
            wordScore = wordScore.multiply(BigInteger.valueOf(i + 1));
            result = result.add(wordScore);
        }
        return result;
    }
}
