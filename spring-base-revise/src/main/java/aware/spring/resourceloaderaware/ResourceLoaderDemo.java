package aware.spring.resourceloaderaware;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * Package: aware.spring.resourceloaderaware
 * Author: houzm
 * Date: Created in 2018/9/4 12:20
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：
 */
@Component
public class ResourceLoaderDemo implements ResourceLoaderAware{


    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void show() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:messages_en_US.properties");
        InputStream inputStream = resource.getInputStream();
        System.out.println(IOUtils.toString(inputStream, "utf-8"));
    }
}
