package aware.spring.resourceloaderaware;

import java.io.IOException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Package: aware.spring.resourceloaderaware
 * Author: houzm
 * Date: Created in 2018/9/4 12:23
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：
 */
public class ResoucesLoaderApp {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext(ResoucesLoaderConfiguration.class);
        ResourceLoaderDemo bean = an.getBean(ResourceLoaderDemo.class);
        bean.show();
        an.close();
    }
}
