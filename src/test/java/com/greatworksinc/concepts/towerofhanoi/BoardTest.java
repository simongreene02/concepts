package com.greatworksinc.concepts.towerofhanoi;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

  private Board board;

  @Before
  public void setUp() {
    board = new Board(3);
  }

  @Test
  public void transferDisc_bothEmpty() {
    Peg from = new Peg();
    Peg to = new Peg();
    assertThat(board.transferDisc(from, to)).isFalse();
    assertThat(from.isEmpty()).isTrue();
    assertThat(to.isEmpty()).isTrue();
  }

  @Test
  public void transferDisc_fromEmpty() {
    Peg from = new Peg();
    Peg to = new Peg();
    to.addDisc(new Disc(1));
    assertThat(board.transferDisc(from, to)).isFalse();
    assertThat(from.isEmpty()).isTrue();
    assertThat(to.getSize()).isEqualTo(1);
  }

  @Test
  public void transferDisc_toEmpty() {
    Peg from = new Peg();
    from.addDisc(new Disc(1));
    Peg to = new Peg();
    assertThat(board.transferDisc(from, to)).isTrue();
    assertThat(from.isEmpty()).isTrue();
    assertThat(to.getSize()).isEqualTo(1);
  }

  @Test
  public void transferDisc_bothFull_fromGreaterThan() {
    Peg from = new Peg();
    from.addDisc(new Disc(2));
    Peg to = new Peg();
    to.addDisc(new Disc(1));
    assertThat(board.transferDisc(from, to)).isFalse();
    assertThat(from.getSize()).isEqualTo(1);
    assertThat(to.getSize()).isEqualTo(1);
  }

  @Test
  public void transferDisc_bothFull_fromEqualTo() {
    Peg from = new Peg();
    from.addDisc(new Disc(1));
    Peg to = new Peg();
    to.addDisc(new Disc(1));
    assertThat(board.transferDisc(from, to)).isFalse();
    assertThat(from.getSize()).isEqualTo(1);
    assertThat(to.getSize()).isEqualTo(1);
  }

  @Test
  public void transferDisc_bothFull_fromLessThan() {
    Peg from = new Peg();
    from.addDisc(new Disc(1));
    Peg to = new Peg();
    to.addDisc(new Disc(2));
    assertThat(board.transferDisc(from, to)).isTrue();
    assertThat(from.isEmpty()).isTrue();
    assertThat(to.getSize()).isEqualTo(2);
  }

  @Test
  public void transferByEnum_leftToMiddle() {
    assertThat(board.transferByEnum(MoveEnum.LEFT_TO_MIDDLE)).isTrue();
    assertThat(board.getLeftPeg().getSize()).isEqualTo(2);
    assertThat(board.getMiddlePeg().getSize()).isEqualTo(1);
    assertThat(board.getRightPeg().isEmpty()).isTrue();
  }

  @Test
  public void transferByEnum_leftToRight() {
    assertThat(board.transferByEnum(MoveEnum.LEFT_TO_RIGHT)).isTrue();
    assertThat(board.getLeftPeg().getSize()).isEqualTo(2);
    assertThat(board.getMiddlePeg().isEmpty()).isTrue();
    assertThat(board.getRightPeg().getSize()).isEqualTo(1);
  }

  @Test
  public void transferByEnum_middleToLeft() {
    assertThat(board.transferByEnum(MoveEnum.LEFT_TO_MIDDLE)).isTrue();
    assertThat(board.transferByEnum(MoveEnum.MIDDLE_TO_LEFT)).isTrue();
    assertThat(board.getLeftPeg().getSize()).isEqualTo(3);
    assertThat(board.getMiddlePeg().isEmpty()).isTrue();
    assertThat(board.getRightPeg().isEmpty()).isTrue();
  }

  @Test
  public void transferByEnum_middleToRight() {
    assertThat(board.transferByEnum(MoveEnum.LEFT_TO_MIDDLE)).isTrue();
    assertThat(board.transferByEnum(MoveEnum.LEFT_TO_RIGHT)).isTrue();
    assertThat(board.transferByEnum(MoveEnum.MIDDLE_TO_RIGHT)).isTrue();
    assertThat(board.getLeftPeg().getSize()).isEqualTo(1);
    assertThat(board.getMiddlePeg().isEmpty()).isTrue();
    assertThat(board.getRightPeg().getSize()).isEqualTo(2);
  }

  @Test
  public void transferByEnum_RightToLeft() {
    assertThat(board.transferByEnum(MoveEnum.LEFT_TO_RIGHT)).isTrue();
    assertThat(board.transferByEnum(MoveEnum.RIGHT_TO_LEFT)).isTrue();
    assertThat(board.getLeftPeg().getSize()).isEqualTo(3);
    assertThat(board.getMiddlePeg().isEmpty()).isTrue();
    assertThat(board.getRightPeg().isEmpty()).isTrue();
  }

  @Test
  public void transferByEnum_RightToMiddle() {
    assertThat(board.transferByEnum(MoveEnum.LEFT_TO_RIGHT)).isTrue();
    assertThat(board.transferByEnum(MoveEnum.LEFT_TO_MIDDLE)).isTrue();
    assertThat(board.transferByEnum(MoveEnum.RIGHT_TO_MIDDLE)).isTrue();
    assertThat(board.getLeftPeg().getSize()).isEqualTo(1);
    assertThat(board.getMiddlePeg().getSize()).isEqualTo(2);
    assertThat(board.getRightPeg().isEmpty()).isTrue();
  }
}
