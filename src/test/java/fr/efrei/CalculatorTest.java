package fr.efrei;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RejectingAuthorizer implements Authorizer {

  @Override
  public boolean authorize() {
    return false;
  }
}

public class CalculatorTest {
  @Test
  void should_throw_when_not_authorized() {
    var rejectingAuthorizer = new RejectingAuthorizer();
    var calculator = new Calculator(rejectingAuthorizer);
    assertThrows(UnauthorizedAccessException.class, () -> {
      calculator.divide(3, 2);
    });
  }
}
