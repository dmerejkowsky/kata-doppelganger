package info.dmerej.mailprovider;

import java.util.Objects;

public final class SendMailResponse {
    private final int code;
    private final String message;

    public SendMailResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        SendMailResponse that = (SendMailResponse) obj;
        return this.code == that.code &&
                Objects.equals(this.message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }

    @Override
    public String toString() {
        return "Response[" +
                "code=" + code + ", " +
                "message=" + message + ']';
    }

}
