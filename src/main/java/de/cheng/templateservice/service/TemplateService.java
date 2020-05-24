package de.cheng.templateservice.service;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Slf4j
public class TemplateService {

  /**
   * Example Service method
   *
   * @param msg
   * @return
   */
  public ResponseEntity<?> exampleMethod(String msg) {
    log.info(msg);
    return new ResponseEntity(msg, HttpStatus.OK);
  }

}
