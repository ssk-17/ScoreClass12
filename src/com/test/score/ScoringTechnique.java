package com.test.score;

import java.math.BigInteger;

/*
 *  Scoring Technique interface provides method
 *  to score the text provided in the file
 *  Each class implementing this interface will
 *  have their customized scoring mechanism
 * */
public interface ScoringTechnique {

    BigInteger findScore(String text);
}
