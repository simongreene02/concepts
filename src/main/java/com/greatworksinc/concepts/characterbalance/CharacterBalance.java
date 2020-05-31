package com.greatworksinc.concepts.characterbalance;

import com.google.common.annotations.VisibleForTesting;
import java.util.*;
import java.util.stream.Collectors;

public class CharacterBalance {
  private static final Map<Character, Character> BRACKETS = Map.of('(', ')', '[', ']', '{', '}');

  @VisibleForTesting
  static boolean checkIfStringBalanced(String inputString) {
    Stack<Character> characterStack = new Stack<>();
    for (char c : inputString.toCharArray()) {
      if (!characterStack.empty() && characterStack.peek() == c) {
        characterStack.pop();
      } else if (BRACKETS.containsKey(c)) {
        characterStack.push(BRACKETS.get(c));
      } else if (BRACKETS.containsValue(c)) {
        return false;
      } else {
        throw new IllegalArgumentException(
            "Input string \"" + inputString + "\" contains illegal characters.");
      }
    }
    return characterStack.empty();
  }

  @VisibleForTesting
  static boolean alternateCheckIfStringBalanced(String inputString) {
    Stack<Character> characterStack = new Stack<>();
    for (char c : inputString.toCharArray()) {
      if (BRACKETS.containsKey(c)) {
        characterStack.push(c);
      } else if (BRACKETS.containsValue(c)) {
        if (characterStack.empty()) {
          return false;
        }
        char maybeOpen = characterStack.pop();
        if (BRACKETS.get(maybeOpen) != c) {
          return false;
        }
      } else {
        throw new IllegalArgumentException(
            "Input string \"" + inputString + "\" contains illegal characters.");
      }
    }
    return characterStack.empty();
  }

  public static List<Boolean> checkIfStringsBalanced(List<String> inputList) {
    return inputList.stream()
        .map(CharacterBalance::checkIfStringBalanced)
        .collect(Collectors.toList());
  }
}
