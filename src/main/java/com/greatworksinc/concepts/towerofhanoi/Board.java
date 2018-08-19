package com.greatworksinc.concepts.towerofhanoi;

import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Board {
    private static final Logger log = LoggerFactory.getLogger(Board.class);

    public Peg getLeftPeg() {
        return leftPeg;
    }

    public Peg getMiddlePeg() {
        return middlePeg;
    }

    public Peg getRightPeg() {
        return rightPeg;
    }

    private final Peg leftPeg;
    private final Peg middlePeg;
    private final Peg rightPeg;
    private final int numberOfDiscs;

    public Board(int numberOfDiscs) {
        this.leftPeg = new Peg();
        this.middlePeg = new Peg();
        this.rightPeg = new Peg();
        this.numberOfDiscs = numberOfDiscs;
        for (int i = this.numberOfDiscs; i > 0; i--) {
            leftPeg.addDisc(new Disc(i));
        }
    }

    /**
     * @param from
     * @param to
     * @return {@code true} if transfer is successful; otherwise {@code false}
     */
    @VisibleForTesting boolean transferDisc(Peg from, Peg to) {
        if (!from.isEmpty()) {
            Disc tempDisc = from.removeDisc().get();
            if (to.addDisc(tempDisc)) {
                //log.info(leftPeg.getSize() + " " + middlePeg.getSize() + " " + rightPeg.getSize());
                log.info("{} {} {}", leftPeg.getSize(), middlePeg.getSize(), rightPeg.getSize());
                return true;
            } else {
                from.addDisc(tempDisc);
            }
        }
        return false;
    }

    public boolean transferByEnum()

    public boolean isGameDone() {
        return leftPeg.isEmpty() && middlePeg.isEmpty() && rightPeg.getSize() == numberOfDiscs;
    }

}
