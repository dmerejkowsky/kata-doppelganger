<?php

namespace Doppelganger;

interface HttpClientInterface
{
    public function post(string $url, object $request): SendMailResponse;
}
