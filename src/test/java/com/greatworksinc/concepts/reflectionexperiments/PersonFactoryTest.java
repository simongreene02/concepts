package com.greatworksinc.concepts.reflectionexperiments;

import static com.google.common.truth.Truth.assertThat;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;

class PersonFactoryTest {

  @Test
  void createPerson()
      throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException,
          InstantiationException, IllegalAccessException, NoSuchFieldException {
    assertThat(PersonFactory.createPerson()).isEqualTo("");
  }
}
