package com.greatworksinc.concepts.towerofhanoi;

import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Board {
    //TODO: Add VisibleForTesting constructor that allows for the direct insertion of pegs.

    private static final Logger log = LoggerFactory.getLogger(Board.class);

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


    @VisibleForTesting Peg getLeftPeg() {
        return leftPeg;
    }

    @VisibleForTesting Peg getMiddlePeg() {
        return middlePeg;
    }

    @VisibleForTesting Peg getRightPeg() {
        return rightPeg;
    }

    /**
     * @param from
     * @param to
     * @return {@code true} if transfer is successful; otherwise {@code false}
     */
    @VisibleForTesting static boolean transferDisc(Peg from, Peg to) {
        if (!from.isEmpty()) {
            Disc tempDisc = from.removeDisc().get();
            if (to.addDisc(tempDisc)) {
                return true;
            } else {
                from.addDisc(tempDisc);
            }
        }
        return false;
    }

    public boolean transferByEnum(MoveEnum moveEnum) {
        log.info("{} {} {}", leftPeg.getSize(), middlePeg.getSize(), rightPeg.getSize());
        if (moveEnum == MoveEnum.LEFT_TO_MIDDLE) {
            return transferDisc(leftPeg, middlePeg);
        } else if (moveEnum == MoveEnum.LEFT_TO_RIGHT) {
            return transferDisc(leftPeg, rightPeg);
        } else if (moveEnum == MoveEnum.MIDDLE_TO_LEFT) {
            return transferDisc(middlePeg, leftPeg);
        } else if (moveEnum == MoveEnum.MIDDLE_TO_RIGHT) {
            return transferDisc(middlePeg, rightPeg);
        } else if (moveEnum == MoveEnum.RIGHT_TO_LEFT) {
            return transferDisc(rightPeg, leftPeg);
        } else if (moveEnum == MoveEnum.RIGHT_TO_MIDDLE) {
            return transferDisc(rightPeg, middlePeg);
        } else {
            return false;
        }
    }

    public boolean isGameDone() {
        return leftPeg.isEmpty() && middlePeg.isEmpty() && rightPeg.getSize() == numberOfDiscs;
    }

}
