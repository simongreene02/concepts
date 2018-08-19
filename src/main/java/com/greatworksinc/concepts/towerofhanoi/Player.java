package com.greatworksinc.concepts.towerofhanoi;

import java.util.Collections;

public class Player {

//    For an even number of disks:
//
//    make the legal move between pegs A and B (in either direction),
//    make the legal move between pegs A and C (in either direction),
//    make the legal move between pegs B and C (in either direction),
//    repeat until complete.
//
//    For an odd number of disks:
//
//    make the legal move between pegs A and C (in either direction),
//    make the legal move between pegs A and B (in either direction),
//    make the legal move between pegs B and C (in either direction),
//    repeat until complete.

    private final Board board;
//    p f mover mover
    private final int maxTurns;
    private int turn;


    public Player(Board board) {
        this.board = board;
//        this.mover = board.getNumberOfDiscs()  == odd? new OddMover(): new EvenMover();
        this.maxTurns = (int) Math.pow(2, board.getNumberOfDiscs()) - 1;
    }

    public void play() {
        while (!board.isGameDone() && turn < maxTurns) {
            if (board.getNumberOfDiscs() % 2 == 1) {
                switch (turn % 3) {
                    case 0:
                        if (!board.transferByEnum(MoveEnum.LEFT_TO_RIGHT)) {
                            board.transferByEnum(MoveEnum.RIGHT_TO_LEFT);
                        }
                        break;
                    case 1:
                        if (!board.transferByEnum(MoveEnum.LEFT_TO_MIDDLE)) {
                            board.transferByEnum(MoveEnum.MIDDLE_TO_LEFT);
                        }
                        break;
                    case 2:
                        if (!board.transferByEnum(MoveEnum.MIDDLE_TO_RIGHT)) {
                            board.transferByEnum(MoveEnum.RIGHT_TO_MIDDLE);
                        }
                        break;
                    default:
                        throw new IllegalStateException("turn % 3 is neither 0, 1, or 2.");

                }
            } else {
                switch (turn % 3) {
                    case 0:
                        if (!board.transferByEnum(MoveEnum.LEFT_TO_MIDDLE)) {
                            board.transferByEnum(MoveEnum.MIDDLE_TO_LEFT);
                        }
                        break;
                    case 1:
                        if (!board.transferByEnum(MoveEnum.LEFT_TO_RIGHT)) {
                            board.transferByEnum(MoveEnum.RIGHT_TO_LEFT);
                        }
                        break;
                    case 2:
                        if (!board.transferByEnum(MoveEnum.MIDDLE_TO_RIGHT)) {
                            board.transferByEnum(MoveEnum.RIGHT_TO_MIDDLE);
                        }
                        break;
                    default:
                        throw new IllegalStateException("turn % 3 is neither 0, 1, or 2.");

                }
            }
            turn++;
        }
        System.out.println(turn);
    }


}
