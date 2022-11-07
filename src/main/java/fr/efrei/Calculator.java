package fr.efrei;

public class Calculator {
  private final Authorizer authorizer;

  Calculator(Authorizer authorizer) {
    this.authorizer = authorizer;
  }

  public int divide(int numerator, int denominator) {
    var authorized = authorizer.authorize();
    if (authorized) { // <- bug here, should be if (!authorized)
      throw new UnauthorizedAccessException("Not authorized");
    }
    return numerator / denominator;
  }
}

