from dataclasses import dataclass


@dataclass
class Request:
    name: str
    email: str
    subject: str
    message: str


class MailSender:
    base_url = "https://api.mailsender.com"

    def __init__(self, http_client):
        self.http_client = http_client

    def send_v1(self, user, message):
        # Bug! Should be `Request(user.name, user.email, ...)`
        request = Request(user.email, user.name, "New notification", message)
        return self.http_client.post(self.base_url, request)

    def send_v2(self, user, message):
        request = Request(user.name, user.email, "New notification", message)
        response = self.http_client.post(self.base_url, request)
        if response.code == 503:
            # Bug! Should be `.post(self.base_url, request)`
            next_try = self.http_client.post(self.base_url, response)
            return next_try
        else:
            return response
