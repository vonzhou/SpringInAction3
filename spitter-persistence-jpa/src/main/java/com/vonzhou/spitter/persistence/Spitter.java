package com.vonzhou.spitter.persistence;

import javax.persistence.*;
import java.util.List;


/**
 * 作为Entity的Spitter不能有List类型的spittles
 */
@Entity
@Table(name="spitter")
public class Spitter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="fullName")
    private String fullName;

    @Column(name="email")
    private String email;
    @Column(name="update_by_email")
    private boolean updateByEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setUpdateByEmail(boolean updateByEmail) {
        this.updateByEmail = updateByEmail;
    }

    public boolean isUpdateByEmail() {
        return updateByEmail;
    }


    @Override
    public boolean equals(Object obj) {
        Spitter other = (Spitter) obj;
        return other.fullName.equals(fullName) && other.username.equals(username) && other.password.equals(password);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
}
