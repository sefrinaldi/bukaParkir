package com.bukaParkir.model;

import com.bukaParkir.common.auditable.ModelBase;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User extends ModelBase {

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_role_id")
    private Role role;

    @NotNull
    private int isActive;

    public User() {
    }

    public User(String name, String email, String password, Role role, int isActive) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public int getIsActive() {
        return isActive;
    }
}
