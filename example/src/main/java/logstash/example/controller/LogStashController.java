package logstash.example.controller;


import logstash.example.controller.dto.LogDto;
import logstash.example.controller.service.LogStashService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LogStashController {

  private final LogStashService logStashService;

  @GetMapping("/hello")
  public ResponseEntity getHello() {
    LogDto logDto = new LogDto("name", "id");
    MDC.put("hello1", "world!!!!!!!!!!!!!!!!!!");
    MDC.put("hello2", "world!!!!!!!!!!!!!!!!!!");
    logStashService.call();
    log.info(logDto.toString());
    MDC.put("hello4", "world!!!!!!!!!!!!!!!!!!");
    MDC.put("hello5", "world!!!!!!!!!!!!!!!!!!");

    return new ResponseEntity("world!!", HttpStatus.OK);
  }
}
