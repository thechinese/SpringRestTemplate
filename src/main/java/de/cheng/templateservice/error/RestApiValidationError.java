package de.cheng.templateservice.error;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
class RestApiValidationError extends AbstractRestApiSubError {

  private String object;
  private String field;
  private Object rejectedValue;
  private String message;

  RestApiValidationError(final String object, final String message) {
    super();
    this.object = object;
    this.message = message;
  }
}
