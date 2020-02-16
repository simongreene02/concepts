package com.greatworksinc.concepts.reflectionexperiments;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class PersonFactory {
  public static Person createPerson()
      throws ClassNotFoundException, IllegalAccessException, InstantiationException,
          NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
    Class<?> personClass = Class.forName("com.greatworksinc.concepts.reflectionexperiments.Person");
    Person person = (Person) personClass.getDeclaredConstructor().newInstance();
    Field name = Person.class.getDeclaredField("name");
    name.setAccessible(true);
    name.set(person, "John");
    Field age = Person.class.getDeclaredField("age");
    age.setAccessible(true);
    age.set(person, 32);
    //        Method setWalksMethod = personClass.getDeclaredMethod("setWalks", boolean.class);
    //        Method walksMethod = personClass.getDeclaredMethod("walks");
    //        boolean walks = (boolean) walksMethod.invoke(bird);
    //        setWalksMethod.invoke(bird, true);
    //        boolean walks2 = (boolean) walksMethod.invoke(bird);
    return person;
  }
}
