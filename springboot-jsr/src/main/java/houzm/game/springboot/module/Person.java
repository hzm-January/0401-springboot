package houzm.game.springboot.module;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

/**
 * Package: houzm.game.springboot.controller
 * Author: houzm
 * Date: Created in 2018/10/22 10:17
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： person
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -223211128645471936L;
    @NotNull
    @Min(value = 1000000)
    @Max(value = 100000000)
    private Long id;
    @Pattern(regexp = "\\D*")
    @Size(max = 10, min = 2)
    private String name;
    @NotEmpty
    @Length(min = 2, max = 10)
    private String addr;

    private Integer age;
    @AssertFalse
    private Boolean isVip;
    @AssertTrue
    private Boolean isLimit;

    // integer最大整数位数，fraction最大小数位数
    @Digits(integer = 100, fraction = 1000)
    private Integer coupon;

    @Valid //嵌套验证
    private PersonDetail personDetail;

    public Boolean getVip() {
        return isVip;
    }

    public void setVip(Boolean vip) {
        isVip = vip;
    }

    public Boolean getLimit() {
        return isLimit;
    }

    public void setLimit(Boolean limit) {
        isLimit = limit;
    }

    public Integer getCoupon() {
        return coupon;
    }

    public void setCoupon(Integer coupon) {
        this.coupon = coupon;
    }

    public PersonDetail getPersonDetail() {
        return personDetail;
    }

    public void setPersonDetail(PersonDetail personDetail) {
        this.personDetail = personDetail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
