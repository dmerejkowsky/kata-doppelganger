<?php

namespace Doppelganger;

final class MailSender
{
    private const BASE_URL = 'https://mailprovider.com';

    public function __construct(
        private readonly HttpClientInterface $httpClient
    ) {
    }

    public function sendV1(User $user, string $message): void
    {
        $email = $user->email;
        $subject = 'New notification';

        // BUG! Should be SendMailRequest($email, $subject, $message);
        $sendRequest = new SendMailRequest($subject, $email, $message);

        $this->httpClient->Post(self::BASE_URL, $sendRequest);
    }

    public function sendV2(User $user, string $message): void
    {
        $email = $user->email;
        $subject = 'New notification';

        $sendRequest = new SendMailRequest($email, $subject, $message);
        $response = $this->httpClient->Post(self::BASE_URL, $sendRequest);

        if ($response->code === 503) {
            // BUG! Should be Post(BASE_URL, sendRequest)
            $this->httpClient->Post(self::BASE_URL, $response);
        }
    }
}
