package com.test.score;

import java.math.BigInteger;

/*
 *  Scoring Technique interface provides method to calculate score based on text provided in file
 *  Class implementing this interface will have their customized scoring technique
 */
public interface ScoringTechnique {

    BigInteger calculateScore(String text);
}
