package info.dmerej;

public interface HttpClient {
  Response post(String url, Object request);
}
