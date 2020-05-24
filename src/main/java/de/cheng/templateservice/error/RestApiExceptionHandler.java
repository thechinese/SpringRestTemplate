package de.cheng.templateservice.error;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class RestApiExceptionHandler extends ResponseEntityExceptionHandler {

  private ResponseEntity<Object> buildResponseEntity(final RestApiError restApiError) {
    return new ResponseEntity<>(restApiError, restApiError.getHttpStatus());
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(
    final HttpMessageNotReadableException ex,
    final HttpHeaders httpHeaders, final HttpStatus httpStatus, final WebRequest webRequest) {
    final String error = "Malformed JSON request";
    final RestApiError restApiError = new RestApiError(HttpStatus.BAD_REQUEST, error, ex);
    return this.buildResponseEntity(restApiError);
  }

}
