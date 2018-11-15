package el.spring;

import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * Package: el.spring
 * Author: houzm
 * Date: Created in 2018/9/3 9:15
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： spring el 调用各种资源的测试
 */
@Component
public class ELDemo {

    //1. 注入普通字符串
    @Value(value = "侯志明")
    private String userName;

    //2. 注入系统属性
    @Value(value = "#{systemProperties['os.name']}")
    private String systemProperty;

    //3. 注入表达式结果
    @Value(value = "#{T(java.lang.Math).random()*100.0}")
    private double calculation;

    //4. 注入其他bean属性
    @Value(value = "#{otherBean.otherName}")
    private String otherBeanProperty;

    //5. 注入文件资源
    @Value(value = "classpath:textresource.txt")
    private Resource resource;

    //6. 注入网址资源
    @Value(value = "http://www.baidu.com")
    private Resource resourceUrl;

    @Value(value = "${jdbc.dbpassword}")
    private String dbpassword;

    public void show() {
        try {
            System.out.println(userName);
            System.out.println(systemProperty);
            System.out.println(calculation);
            System.out.println(otherBeanProperty);
            System.out.println(IOUtils.toString(resource.getInputStream(), "utf-8"));
            System.out.println(IOUtils.toString(resourceUrl.getInputStream(), "utf-8"));
            System.out.println(dbpassword);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
