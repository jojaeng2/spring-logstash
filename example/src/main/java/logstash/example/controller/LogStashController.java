package logstash.example.controller;


import logstash.example.controller.dto.LogDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class LogStashController {

  @GetMapping("/hello")
  public ResponseEntity getHello() {
    LogDto logDto = new LogDto("name", "id");
    log.info(logDto.toString());
    return new ResponseEntity("world!!", HttpStatus.OK);
  }
}
