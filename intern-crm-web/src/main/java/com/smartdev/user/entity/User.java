package com.smartdev.user.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class User {
    private String userName;
    private String passWord;
    private Integer role;
    private Integer isDelete;
    private Collection<Customer> customersByUserName;
    private SellerDetail sellerDetailByUserName;

    @Id
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "pass_word")
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Basic
    @Column(name = "role")
    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Basic
    @Column(name = "isDelete")
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(passWord, user.passWord) &&
                Objects.equals(role, user.role) &&
                Objects.equals(isDelete, user.isDelete);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userName, passWord, role, isDelete);
    }

    @OneToMany(mappedBy = "userBySeller")
    public Collection<Customer> getCustomersByUserName() {
        return customersByUserName;
    }

    public void setCustomersByUserName(Collection<Customer> customersByUserName) {
        this.customersByUserName = customersByUserName;
    }

    @OneToOne(mappedBy = "userByUserName")
    public SellerDetail getSellerDetailByUserName() {
        return sellerDetailByUserName;
    }

    public void setSellerDetailByUserName(SellerDetail sellerDetailByUserName) {
        this.sellerDetailByUserName = sellerDetailByUserName;
    }
}
