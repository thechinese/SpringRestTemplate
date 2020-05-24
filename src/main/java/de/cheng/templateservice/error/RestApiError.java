package de.cheng.templateservice.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Collection;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
final class RestApiError {

  HttpStatus httpStatus;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  LocalDateTime timestamp;

  private String message;

  private String debugMessage;

  private Collection<AbstractRestApiSubError> subErrors;

  private RestApiError() {
    super();
    this.timestamp = LocalDateTime.now();
  }

  RestApiError(final HttpStatus httpStatus) {
    this();
    this.httpStatus = httpStatus;
  }

  RestApiError(final HttpStatus httpStatus, final Throwable throwable) {
    this();
    this.httpStatus = httpStatus;
    this.message = "Unexpected error";
    this.debugMessage = throwable.getLocalizedMessage();
  }

  RestApiError(final HttpStatus httpStatus, final String message, final Throwable throwable) {
    this();
    this.httpStatus = httpStatus;
    this.message = message;
    this.debugMessage = throwable.getLocalizedMessage();
  }
}
