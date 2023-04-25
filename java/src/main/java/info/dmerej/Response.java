package info.dmerej;

import java.util.Objects;

public final class Response {
    private final int code;
    private final String message;

    Response(int code, String message) {
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
        Response that = (Response) obj;
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
