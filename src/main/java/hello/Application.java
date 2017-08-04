package hello;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String home() {
        return "Hello World from Spring Boot!";
    }

    @RequestMapping("/oops")
    public void fail() {
        System.exit(1);
    }

    @RequestMapping("/node")
    public String helloNode() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://hello-node:8080", HttpMethod.GET, new HttpEntity(""), String.class);
        return "Calling hello-node from Spring Boot: " + responseEntity.getBody();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
