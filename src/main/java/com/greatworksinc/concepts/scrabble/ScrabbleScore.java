package com.greatworksinc.concepts.scrabble;

import java.util.HashMap;
import java.util.Map;

public class ScrabbleScore {
    private static final char[] LETTERS = {'A', 'B', 'C'};
    private static final int[] POINTS = {1, 2, 3};

    /**
     * Given a word, compute the scrabble score for that word.
     *
     * <p>--Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B, C, M, P = 3;
     * F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples "cabbage" should be scored as worth 14
     * points:
     *
     * <p>3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1 point for E And
     * to total:
     *
     * <p>3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
     *
     * Come up two implementations and analyze time and space complexity in terms of big-O.
     *
     * Goal
     * Time O(N) Space O(1)
     *
     * input[] = {1,2,3,4}
     * inplace: O(1)
     * use one variable for swap O(1)
     * copy input[] to input2[] : O(N)
     * if recusively O(N2)
     *
     * @param string
     * @return
     *
     */
    public static int getScrabbleScore(String string) {
        int score = 0;
        for (char c : string.toUpperCase().toCharArray()) {
            for (int i = 0; i < LETTERS.length; i++) {
                if (c == LETTERS[i]) {
                    score += POINTS[i];
                    break;
                }
            }
        }
        return score;
    }
}