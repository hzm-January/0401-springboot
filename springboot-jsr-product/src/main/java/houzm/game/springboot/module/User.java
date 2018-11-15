package houzm.game.springboot.module;

import houzm.game.springboot.validgroup.Create;
import houzm.game.springboot.validgroup.Delete;
import houzm.game.springboot.validgroup.Read;
import houzm.game.springboot.validgroup.Update;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 * Package: houzm.game.springboot.module
 * Author: houzm
 * Date: Created in 2018/10/22 13:29
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： user module
 */
public class User implements Serializable{
    private static final long serialVersionUID = -6010642105751380174L;

    @NotNull
    @Min(value = 1000000, groups = {Create.class, Update.class, Delete.class, Read.class}, message = "总书记对伐啦计算的发")
    @Max(value = 100000000, groups = {Create.class, Update.class, Delete.class, Read.class})
    private Long id;
    @Pattern(regexp = "\\D*", groups = {Create.class, Update.class})
    @Size(max = 10, min = 2)
    private String name;
    @NotEmpty
    @Length(min = 2, max = 10)
    private String addr;

    @Size(min = 15, max = 18, groups = {Create.class})
    private String cardId;
    @Range(min = 1, max = 120)
    private Integer age;
    @AssertFalse
    private Boolean isVip;
    @AssertTrue
    private Boolean isLimit;

    // integer最大整数位数，fraction最大小数位数
    @Digits(integer = 100, fraction = 1000)
    private Integer coupon;

    @Valid //嵌套验证
    private UserDetail userDetail;

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", age=" + age +
                ", isVip=" + isVip +
                ", isLimit=" + isLimit +
                ", coupon=" + coupon +
                ", userDetail=" + userDetail +
                '}';
    }
}
