package base.springmvc;

import java.io.Serializable;
import java.util.Date;

/**
 * Package: base.springmvc
 * Author: houzm
 * Date: Created in 2018/9/8 21:03
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class UserForCustomConverter implements Serializable {
    private String id;
    private String name;
    private Integer age;
    private String address;
    private Date birth;

    public UserForCustomConverter() {

    }

    public UserForCustomConverter(String id, String name, Integer age, String address, Date birth) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.birth = birth;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", birth=" + birth +
                '}';
    }
}