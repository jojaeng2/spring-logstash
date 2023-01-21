package logstash.example.controller.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

public class LogDto {
  private final String name;
  private final String id;


  public LogDto(String name, String id) {
    this.name = name;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public String getId() {
    return id;
  }

  @Override
  public String toString() {
    return "LogDto{" +
        "name='" + name + '\'' +
        ", id='" + id + '\'' +
        '}';
  }
}
