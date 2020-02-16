package com.greatworksinc.concepts.unsafell;

public class CircularDetector {
  public static boolean isCircular(UnSafeNode root) {
    if (root == null) {
      return false;
    }
    UnSafeNode pointer1 = root;
    UnSafeNode pointer2 = root;
    boolean advancePointer1 = false;
    while (true) {
      if (pointer1.getNextItem() == null || pointer2.getNextItem() == null) {
        return false;
      }
      pointer2 = pointer2.getNextItem();
      if (advancePointer1) {
        pointer1 = pointer1.getNextItem();
      }
      advancePointer1 = !advancePointer1;
      if (advancePointer1 && pointer1 == pointer2) {
        return true;
      }
    }
  }
}
