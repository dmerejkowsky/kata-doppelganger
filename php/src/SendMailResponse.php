<?php

namespace Doppelganger;

final class SendMailResponse
{
    public function __construct(
        public readonly int $code,
        public readonly string $message
    ) {
    }
}
