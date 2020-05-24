package de.cheng.templateservice.api;

import de.cheng.templateservice.service.TemplateService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/trans")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Validated
public class TemplateRestController {

  TemplateService templateService;

  @ResponseStatus(HttpStatus.ACCEPTED)
  @PostMapping(path = "/helloTemplate")
  public void transform(String msg) {

    this.templateService.exampleMethod(msg);
  }

}
