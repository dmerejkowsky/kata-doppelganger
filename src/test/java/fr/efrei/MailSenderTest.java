package fr.efrei;

import fr.efrei.mailprovider.SendRequest;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpyClient implements HttpClient {
  SendRequest request;

  @Override
  public Response post(String url, Object request) {
    this.request = (SendRequest) request;
    return new Response(200, "OK");
  }
}

class FakeClient implements HttpClient {
  int returnCode;

  @Override
  public Response post(String url, Object request) {
    if (!(request instanceof SendRequest)) {
      throw new InvalidParameterException(String.format("Expected SendRequest, got %s", request.getClass().getName()));
    }
    return new Response(returnCode, "OK");
  }
}

public class MailSenderTest {
  private final User alice = new User("alice", "alice@domain.tld");

  @Test
  void should_make_a_sendgrid_request() {
    var spyClient = new SpyClient();
    var mailSender = new MailSender(spyClient);

    mailSender.sendV1(alice, "You've got mail");

    var sent = spyClient.request;
    assertEquals(sent.name(), alice.name());
    assertEquals(sent.email(), alice.email());
  }

  @Test
  void should_retry_when_getting_a_503_error() {
    var fakeClient = new FakeClient();
    var mailSender = new MailSender(fakeClient);

    fakeClient.returnCode = 503;
    mailSender.sendv2(alice, "You've got mail");

  }
}
