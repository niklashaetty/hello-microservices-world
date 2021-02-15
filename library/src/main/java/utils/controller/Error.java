package utils.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class Error {
    private final Integer code;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private final LocalDateTime timestamp;
    private final String message;
    private final String detail;

    private Error(final Builder builder) {
        this.code = builder.code;
        this.timestamp = builder.timestamp;
        this.message = builder.message;
        this.detail = builder.detail;
    }

    public static Builder builder(final Integer code) {
        return new Builder(code);
    }

    public static class Builder {
        private final Integer code;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
        private final LocalDateTime timestamp;
        private String message = "Unknown error occurred";
        private String detail = "";

        public Builder(final Integer code){
            this.code = code;
            this.timestamp = LocalDateTime.now();
        }

        public Builder message(final String message) {
            this.message = message;
            return this;
        }

        public Builder detail(final String detail) {
            this.detail = detail;
            return this;
        }

        public Error build() {
            return new Error(this);
        }
    }

    public Integer getCode() {
        return code;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }
}
