package com.smartdev.user.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    private String userName;
    private String passWord;
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
    @Column(name = "isDelete")
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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

    @ManyToMany
    @JoinTable(name="user_role",
            joinColumns = @JoinColumn(name = "user_name"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
