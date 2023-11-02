<?php

namespace Doppelganger;

use Exception;

final class SafeCalculator
{
    public function __construct(
        private readonly AuthorizerInterface $authorizer
    ) {
    }

    public function add(int $x, int $y): int
    {
        $authorized = $this->authorizer->authorize();

        // BUG! Should be if (!$authorized)
        if ($authorized) {
            throw new Exception('Not authorized');
        }

        return $x + $y;
    }
}
