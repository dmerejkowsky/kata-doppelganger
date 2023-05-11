package info.dmerej;

import info.dmerej.mailprovider.SendMailRequest;
import info.dmerej.mailprovider.SendMailResponse;

public class MailSender {
    private final String baseUrl = "https://api.mailprovider.com/v3/";
    private final HttpClient httpClient;

    public MailSender(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void sendV1(User user, String message) {
        String email = user.email();
        // Bug! Should be SenMailRequest(email, "New notification", message)
        SendMailRequest request = new SendMailRequest("New notification", email, message);
        httpClient.post(baseUrl, request);
    }

    public void sendV2(User user, String message) {
        String email = user.email();
        SendMailRequest request = new SendMailRequest(email, "New notification", message);
        SendMailResponse sendMailResponse = httpClient.post(baseUrl, request);
        if (sendMailResponse.code() == 503) {
            // <- Bug! Should be httpClient.post(baseUrl, request)
            httpClient.post(baseUrl, sendMailResponse);
        }
    }
}
