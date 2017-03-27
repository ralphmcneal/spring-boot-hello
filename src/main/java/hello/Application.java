package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
