package houzm.game.springboot.module;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.Range;

/**
 * Package: houzm.game.springboot.module
 * Author: houzm
 * Date: Created in 2018/10/22 10:38
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： person detail
 */
public class PersonDetail implements Serializable {
    private static final long serialVersionUID = -2944005964165346421L;

    @Email
    private String email;
    @Past
    private Date birthDay;
    @Future
    private Date marry;
    @DecimalMax(value = "100000000.10")
    @DecimalMin(value = "1000000.20")
    private BigDecimal asset;

    @Range(min = 0, max = 100)
    private Integer exGirlFriend;

    public Integer getExGirlFriend() {
        return exGirlFriend;
    }

    public void setExGirlFriend(Integer exGirlFriend) {
        this.exGirlFriend = exGirlFriend;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Date getMarry() {
        return marry;
    }

    public void setMarry(Date marry) {
        this.marry = marry;
    }

    public BigDecimal getAsset() {
        return asset;
    }

    public void setAsset(BigDecimal asset) {
        this.asset = asset;
    }
}
