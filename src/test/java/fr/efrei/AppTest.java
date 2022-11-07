package fr.efrei;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
  @Test
  void getAnswer() {
    var app = new App();
    int actual = app.getAnswer();
    assertEquals(42, actual);
  }
}
