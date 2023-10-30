<?php

namespace Doppelganger;

final class User
{
    public function __construct(
        public readonly string $name,
        public readonly string $email
    ) {
    }
}
