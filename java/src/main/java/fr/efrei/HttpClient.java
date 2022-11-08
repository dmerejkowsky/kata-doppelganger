package fr.efrei;

public interface HttpClient {
  Response post(String url, Object request);
}
