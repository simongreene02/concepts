package com.greatworksinc.concepts.towerofhanoi;

import java.util.EmptyStackException;
import java.util.Optional;
import java.util.Stack;

public class Peg {
  private Stack<Disc> discs;

  public Peg() {
    discs = new Stack<Disc>();
  }

  public boolean addDisc(Disc disc) {
    if (!discs.empty() && !discs.peek().isBiggerThan(disc)) {
      return false;
    } else {
      return discs.add(disc);
    }
  }

  public Optional<Disc> removeDisc() {
    try {
      return Optional.of(discs.pop());
    } catch (EmptyStackException e) {
      return Optional.empty();
    }
  }

  public int getSize() {
    return discs.size();
  }

  public boolean isEmpty() {
    return discs.isEmpty();
  }
}
