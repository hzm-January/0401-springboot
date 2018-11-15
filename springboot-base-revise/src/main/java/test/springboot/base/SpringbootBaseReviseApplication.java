package test.springboot.base;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class SpringbootBaseReviseApplication {

    public static void main(String[] args) {
        // 1.第一种启动方式--原生启动方式
//        ConfigurableApplicationContext app = SpringApplication.run(SpringbootBaseReviseApplication.class, args);
        // 2.第二种启动方式
        SpringApplication application = new SpringApplication(SpringbootBaseReviseApplication.class);
        application.setBannerMode(Banner.Mode.OFF); //关闭banner图案

        //2.添加数据源
        Map<String,Object> map = new HashMap<>();
        map.put("spring.datasource.url","jdbc:mysql://120.55.43.95:3306/luckyair?useSSL=false");
        map.put("spring.datasource.username","luckyair");
        map.put("spring.datasource.password","luckyair");

        //3.开启驼峰映射 (Such as account_id ==> accountId)
        map.put("mybatis.configuration.map-underscore-to-camel-case",true);
        application.setDefaultProperties(map);

        application.run(args);
    }

//    @Bean
//    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
//         return new DataSourceTransactionManager(dataSource);
//    }
}
