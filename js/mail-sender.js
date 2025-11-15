class SendMailRequest {
  constructor(recipient, subject, body) {
    this.recipient = recipient;
    this.subject = subject;
    this.body = body;
  }
}

class MailSender {
  constructor(httpClient) {
    this.baseUrl = "https://api.mailsender.com/v3/";
    this.httpClient = httpClient;
  }

  sendV1(user, message) {
    const { name, email } = user;
    // Bug! Should be `new SendMailRequest(email, 'New notification', message)`
    const request = new SendMailRequest("New notification", email, message);
    this.httpClient.post(this.baseUrl, request);
  }

  sendV2(user, message) {
    const { email } = user;
    const request = new SendMailRequest(email, "New notification", message);
    const response = this.httpClient.post(this.baseUrl, request);
    if (response.code === 503) {
      // Bug! Should be `post(this.baseUrl, request)
      const nextTry = this.httpClient.post(this.baseUrl, response);
      return nextTry;
    } else {
      return response;
    }
  }
}

export default { SendMailRequest, MailSender };
