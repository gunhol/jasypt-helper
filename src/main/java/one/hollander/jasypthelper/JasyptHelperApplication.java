package one.hollander.jasypthelper;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class JasyptHelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(JasyptHelperApplication.class, args);
    }

}
