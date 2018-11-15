package houzm.game.springboot;

import houzm.game.springboot.util.SpringBeanUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootGetbeanConfigsetApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootGetbeanConfigsetApplication.class, args);
		SpringBeanUtil.setApplicationContext(applicationContext);
	}
}
