package logstash.example.controller;


import logstash.example.controller.dto.LogDto;
import logstash.example.controller.service.LogStashService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LogStashController {

  private final LogStashService logStashService;

  @GetMapping("/hello")
  public ResponseEntity getHello() {
    logStashService.call();

    return new ResponseEntity("world!!", HttpStatus.OK);
  }

  @PostMapping("/world")
  public ResponseEntity postWorld(@RequestBody TestDto request) {
    return new ResponseEntity(new TestResponse("World!!!!!!!!!!!!!"), HttpStatus.OK);
  }


  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class TestDto {
    private String name;
    private String id;
  }

  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class TestResponse {
    private String res;
  }
}
