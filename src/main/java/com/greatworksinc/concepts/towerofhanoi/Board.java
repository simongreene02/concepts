package com.greatworksinc.concepts.towerofhanoi;

public class Board {
    Peg leftPeg;
    Peg middlePeg;
    Peg rightPeg;
    int numberOfDiscs;

    public Board () {
        for (int i = numberOfDiscs; i > 0; i--) {
            leftPeg.addDisc(new Disc(i));
        }
    }

    boolean transferDisc (Peg from, Peg to) {
        if (from.getSize() > 0) {
            Disc tempDisc = from.removeDisc().get();
            if (to.addDisc(tempDisc)) {
                return true;
            } else {
                from.addDisc(tempDisc);
            }
        }
        return false;
    }
    boolean isGameDone () {
        return (leftPeg.getSize() == 0 && middlePeg.getSize() == 0 && rightPeg.getSize() == numberOfDiscs);
    }
    void getTransitions() {

    }
}
