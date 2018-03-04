package nmfs.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"nmfs.ms","nmfs.ms.rest"})
public class MicroservicesApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MicroservicesApplication.class, args);
        ApplicationContext context = SpringApplication.run(MicroservicesApplication.class, args);

        try {Thread.sleep(300 * 60000); // minutes
        }catch (Exception ex) {}
	}
}
