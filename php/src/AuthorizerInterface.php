<?php

namespace Doppelganger;

interface AuthorizerInterface
{
    public function authorize(): bool;
}
