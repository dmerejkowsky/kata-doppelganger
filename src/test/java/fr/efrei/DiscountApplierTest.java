package fr.efrei;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpyNotifier implements Notifier {
  int count;

  public SpyNotifier() {
    this.count = 0;
  }

  @Override
  public void notify(User user, String message) {
    count++;
  }
}

record Notification(User user, String message) {
}

class MockNotifier implements Notifier {
  public final List<Notification> calls;

  MockNotifier() {
    this.calls = new ArrayList<>();
  }

  @Override
  public void notify(User user, String message) {
    var notification = new Notification(user, message);
    calls.add(notification);
  }
}

public class DiscountApplierTest {

  private final User alice = new User("alice", "alice@omain.tld");

  private final User bob = new User("bob", "bob@domain.tld");


  @Test
  void should_notify_twice_when_applying_discount_for_two_users_v1() {
    // TODO: trigger the bug in DiscountApplier.applyV1() by implementing the Notifier interface
    var spyNotifier = new SpyNotifier();
    var discountApplier = new DiscountApplier(spyNotifier);

    discountApplier.applyV1(0.8, List.of(alice, bob));

    assertEquals(2, spyNotifier.count);
  }

  @Test
  void should_notify_users_when_applying_discount_for_two_users_v2() {
    var mockNotifier = new MockNotifier();
    var discountApplier = new DiscountApplier(mockNotifier);

    discountApplier.applyV2(0.8, List.of(alice, bob));

    var expected = List.of(alice, bob);
    var expectedMails = expected.stream().map(n -> n.email()).toList();
    var actualMails = mockNotifier.calls.stream().map(n -> n.user().email()).toList();
    assertEquals(expectedMails, actualMails);
  }

}
