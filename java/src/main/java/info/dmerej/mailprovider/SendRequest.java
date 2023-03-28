package info.dmerej.mailprovider;

public record SendRequest(String name, String email, String subject, String message) {
}
