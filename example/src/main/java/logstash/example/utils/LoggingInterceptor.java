package logstash.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

@Slf4j
@RequiredArgsConstructor
@Component
public class LoggingInterceptor implements HandlerInterceptor {

  private final ObjectMapper objectMapper;

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    if (request.getClass().getName().contains("SecurityContextHolderAwareRequestWrapper")) return;
    final ContentCachingRequestWrapper cachingRequest = (ContentCachingRequestWrapper) request;
    final ContentCachingResponseWrapper cachingResponse = (ContentCachingResponseWrapper) response;

    if (cachingRequest.getContentType() != null && cachingRequest.getContentType().contains("application/json")) {
      if (cachingRequest.getContentAsByteArray() != null && cachingRequest.getContentAsByteArray().length != 0){
        log.info("Request Body : {}", objectMapper.readTree(cachingRequest.getContentAsByteArray()));
      }
    }
    if (cachingResponse.getContentType() != null && cachingResponse.getContentType().contains("application/json")) {
      if (cachingResponse.getContentAsByteArray() != null && cachingResponse.getContentAsByteArray().length != 0) {
        log.info("Response Body : {}", objectMapper.readTree(cachingResponse.getContentAsByteArray()));
      }
    }
  }
}
