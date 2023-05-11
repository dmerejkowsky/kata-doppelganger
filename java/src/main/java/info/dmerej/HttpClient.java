package info.dmerej;

import info.dmerej.mailprovider.SendMailResponse;

public interface HttpClient {
    SendMailResponse post(String url, Object request);
}
