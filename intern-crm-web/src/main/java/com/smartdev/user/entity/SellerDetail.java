package com.smartdev.user.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "seller_detail", schema = "crm_db", catalog = "")
public class SellerDetail {
    private String userName;
    private String name;
    private Integer age;
    private String mail;
    private Integer phone;
    private String avatar;
    private User userByUserName;

    @Id
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerDetail that = (SellerDetail) o;
        return Objects.equals(userName, that.userName) &&
                Objects.equals(name, that.name) &&
                Objects.equals(age, that.age) &&
                Objects.equals(mail, that.mail) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(avatar, that.avatar);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userName, name, age, mail, phone, avatar);
    }

    @OneToOne
    @JoinColumn(name = "user_name", referencedColumnName = "user_name", nullable = false)
    public User getUserByUserName() {
        return userByUserName;
    }

    public void setUserByUserName(User userByUserName) {
        this.userByUserName = userByUserName;
    }
}
