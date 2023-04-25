package info.dmerej;

public class SafeCalculator {
  private final Authorizer authorizer;

  SafeCalculator(Authorizer authorizer) {
    this.authorizer = authorizer;
  }

  public int add(int left, int right) {
    boolean authorized = authorizer.authorize();
    if (authorized) { // <- bug here, should be if (!authorized)
      throw new UnauthorizedAccessException("Not authorized");
    }
    return left + right;
  }
}

