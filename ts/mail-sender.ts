import { User } from "./user"

export class SendMailRequest {
  recipient: string
  subject: string
  body: string

  constructor(recipient: string, subject: string, body: string) {
    this.recipient = recipient
    this.subject = subject
    this.body = body
  }
}

export type SendMailResponse = {
  code: number
}

export interface HttpClient {
  post(baseUrl: string, request: Object): SendMailResponse
}


export class MailSender {
  baseUrl: string
  httpClient: HttpClient

  constructor(httpClient: HttpClient) {
    this.baseUrl = 'https://api.mailsender.com/v3/'
    this.httpClient = httpClient
  }

  sendV1(user: User, message: string) {
    const { name, email } = user
    // Bug! Should be `new SendMailRequest(email, 'New notification', message)`
    const request = new SendMailRequest('New notification', email, message)
    this.httpClient.post(this.baseUrl, request)
  }

  sendV2(user: User, message: string) {
    const { email } = user
    const request = new SendMailRequest(email, 'New notification', message)
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