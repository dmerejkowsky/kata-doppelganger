package info.dmerej.mailprovider;

import java.util.Objects;

public final class SendRequest {
    private final String name;
    private final String email;
    private final String subject;
    private final String message;

    public SendRequest(String name, String email, String subject, String message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }

    public String subject() {
        return subject;
    }

    public String message() {
        return message;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        SendRequest that = (SendRequest) obj;
        return Objects.equals(this.name, that.name) &&
            Objects.equals(this.email, that.email) &&
            Objects.equals(this.subject, that.subject) &&
            Objects.equals(this.message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, subject, message);
    }

    @Override
    public String toString() {
        return "SendRequest[" +
            "name=" + name + ", " +
            "email=" + email + ", " +
            "subject=" + subject + ", " +
            "message=" + message + ']';
    }

}
