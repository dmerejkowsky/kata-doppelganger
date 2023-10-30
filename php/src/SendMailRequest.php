<?php

namespace Doppelganger;

final class SendMailRequest
{
    public function __construct(
        public readonly string $recipient,
        public readonly string $subject,
        public readonly string $body
    ) {
    }
}
