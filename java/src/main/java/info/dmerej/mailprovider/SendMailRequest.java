package info.dmerej.mailprovider;

import java.util.Objects;

public final class SendMailRequest {
    private final String recipient;
    private final String subject;
    private final String body;

    public SendMailRequest(String recipient, String subject, String body) {
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }


    public String recipient() {
        return recipient;
    }

    public String subject() {
        return subject;
    }

    public String body() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SendMailRequest that = (SendMailRequest) o;
        return recipient.equals(that.recipient) && subject.equals(that.subject) && body.equals(that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipient, subject, body);
    }

    @Override
    public String toString() {
        return "SendMailRequest{" +
                "recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
