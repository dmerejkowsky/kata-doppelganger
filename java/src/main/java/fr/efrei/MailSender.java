package fr.efrei;

import fr.efrei.mailprovider.SendRequest;

public class MailSender {
  private final String baseUrl = "https://api.mailprovider.com/v3/";
  private final HttpClient httpClient;

  public MailSender(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  public void sendV1(User user, String message) {
    String name = user.name();
    String email = user.email();
    // Bug! Should be SendRequest(name, email ...)
    var request = new SendRequest(email, name, "New notification", message);
    httpClient.post(baseUrl, request);
  }

  public void sendv2(User user, String message) {
    String name = user.name();
    String email = user.email();
    var request = new SendRequest(name, email, "New notification", message);
    var response = httpClient.post(baseUrl, request);
    if (response.code() == 503) {
      // <- Bug! Should be httpClient.post(baseUrl, request)
      httpClient.post(baseUrl, response);
    }
  }
}
