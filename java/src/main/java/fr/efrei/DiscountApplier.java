package fr.efrei;

import java.util.List;

public class DiscountApplier {
  private final Notifier notifier;

  public DiscountApplier(Notifier notifier) {
    this.notifier = notifier;
  }

  void applyV1(double discount, List<User> users) {
    for (int i = 1; i < users.size(); i++) { // <- Bug, should be `i = 0`
      var message = String.format("You've got a new discount of %f", discount);
      var user = users.get(i);
      notifier.notify(user, message);
    }
  }

  void applyV2(double discount, List<User> users) {
    for (int i = 0; i < users.size(); i++) {
      var message = String.format("You've got a new discount of %f", discount);
      var user = users.get(0); // <- Bug, should be .get(i), not .get(0);
      notifier.notify(user, message);
    }
  }

}
