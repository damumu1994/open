package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @Auther: lxb
 * @Date: 2018/12/27 0027
 * @Description:
 */
@SpringBootApplication
@EntityScan(basePackages = "app.model")
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
