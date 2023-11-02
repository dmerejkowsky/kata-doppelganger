<?php

namespace Doppelganger;

final class DiscountApplier
{
    public function __construct(
        private readonly NotifierInterface $notifier
    ) {
    }

    public function applyV1(int $discount, array $users): void
    {
        // BUG! should be i = 0
        for ($i = 1; $i < count($users); $i++) {
            $message = "You've got a discount of {$discount}%";

            $user = $users[$i];

            $this->notifier->notify($user, $message);
        }
    }

    public function applyV2(int $discount, array $users): void
    {
        for ($i = 0; $i < count($users); $i++) {
            $message = "You've got a discount of {$discount}%";

            // BUG! should be users[i]
            $user = $users[0];

            $this->notifier->notify($user, $message);
        }
    }
}
