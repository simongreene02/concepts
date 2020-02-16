package com.greatworksinc.concepts.towerofhanoi;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class PlayerTest {
  @Test
  public void play_odd() {
    Board board = new Board(3);
    Player player = new Player(board);
    player.play();
    assertThat(board.getLeftPeg().isEmpty()).isTrue();
    assertThat(board.getMiddlePeg().isEmpty()).isTrue();
    assertThat(board.getRightPeg().getSize()).isEqualTo(3);
  }

  @Test
  public void play_even() {
    Board board = new Board(4);
    Player player = new Player(board);
    player.play();
    assertThat(board.getLeftPeg().isEmpty()).isTrue();
    assertThat(board.getMiddlePeg().isEmpty()).isTrue();
    assertThat(board.getRightPeg().getSize()).isEqualTo(4);
  }
}
