class Request {
  constructor (name, email, subject, message) {
    this.name = name
    this.email = email
    this.subject = subject
    this.message = message
  }
}

class MailSender {
  constructor (httpClient) {
    this.baseUrl = 'https://api.mailsender.com/v3/'
    this.httpClient = httpClient
  }

  sendV1 (user, message) {
    const { name, email } = user
    // Bug! Should be `new Request(name, email, 'New notification', message)`
    const request = new Request(email, name, 'New notification', message)
    this.httpClient.post(this.baseUrl, request)
  }

  sendV2 (user, message) {
    const { name, email } = user
    const request = new Request(name, email, 'New notification', message)
    const response = this.httpClient.post(this.baseUrl, request)
    if (response.code === 503) {
      // Bug! Should be `post(this.baseUrl, request)
      const nextTry = this.httpClient.post(this.baseUrl, response)
      return nextTry
    } else {
        return response
    }
  }
}

module.exports = { MailSender, Request }
