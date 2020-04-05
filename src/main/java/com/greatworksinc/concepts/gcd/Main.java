package com.greatworksinc.concepts.gcd;

public class Main {
  public static int gcdIterative(int a, int b) {
    if (a < 0 || b < 0) {
      throw new IllegalArgumentException("Both numbers must be non-negative integers");
    }
    if (a == 0) {
      return b;
    }
    if (b == 0) {
      return a;
    }
    for (int gcd = Math.min(a, b); gcd > 0; gcd--) {
      if (a % gcd == 0 && b % gcd == 0) {
        return gcd;
      }
    }
    throw new IllegalStateException("The program was unable to caclulate a GCD for these values.");
  }

  public static int gcdEuclidean(int a, int b) {
    if (a < 0 || b < 0) {
      throw new IllegalArgumentException("Both numbers must be non-negative integers");
    }
    if (b == 0) {
      return a;
    }
    return gcdEuclidean(b, a % b);
  }
}
