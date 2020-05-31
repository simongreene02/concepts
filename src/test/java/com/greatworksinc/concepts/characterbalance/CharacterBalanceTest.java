package com.greatworksinc.concepts.characterbalance;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CharacterBalanceTest {

  @Test
  void checkIfStringBalanced_emptyString() {
    assertThat(CharacterBalance.checkIfStringBalanced("")).isTrue();
  }

  @Test
  void checkIfStringBalanced_parentheses() {
    assertThat(CharacterBalance.checkIfStringBalanced("()")).isTrue();
  }

  @Test
  void checkIfStringBalanced_sqr() {
    assertThat(CharacterBalance.checkIfStringBalanced("[]")).isTrue();
  }

  @Test
  void checkIfStringBalanced_missingCloseSqr() {
    assertThat(CharacterBalance.checkIfStringBalanced("[")).isFalse();
  }

  @Test
  void checkIfStringsBalanced() {
    assertThat(
            CharacterBalance.checkIfStringsBalanced(
                List.of("{}()", "[{()}]", "({()})", "{}(", "({)}", "[[", "}{")))
        .containsExactly(true, true, true, false, false, false, false)
        .inOrder();
  }
}
