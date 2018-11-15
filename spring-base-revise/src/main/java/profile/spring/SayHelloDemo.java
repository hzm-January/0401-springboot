package profile.spring;

/**
 * Package: profile.spring
 * Author: houzm
 * Date: Created in 2018/9/3 12:32
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class SayHelloDemo {

    private String content;

    public SayHelloDemo(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void show() {
        System.out.println("say hello to : "+content);
    }
}
