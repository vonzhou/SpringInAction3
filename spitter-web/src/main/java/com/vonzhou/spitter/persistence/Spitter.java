package com.vonzhou.spitter.persistence;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;


/**
 * 添加校验注解
 * TODO 确保username的唯一性
 */
public class Spitter {
    private Long id;
    @Size(min = 3, max = 20, message = "Username must be btw 3 and 20 characters long.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces.")
    private String username;
    @Size(min = 6, max = 20, message = "The password must at least 6 characters long.")
    private String password;

    @Size(min = 3, max = 50, message = "Your full name must be btw 3 and 50 charaters long.")
    private String fullName;
    private List<Spittle> spittles;

    @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[A-Za-z]{2,4}", message = "Invalid email address.")
    private String email;
    private boolean updateByEmail;

    public static final Spitter FAKE_SPITTER = new Spitter();
    static {
        FAKE_SPITTER.setUsername("Spitter Not Exists, Go Create It.");
    }

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

    public void setSpittles(List<Spittle> spittles) {
        this.spittles = spittles;
    }

    public List<Spittle> getSpittles() {
        return spittles;
    }

    public void setUpdateByEmail(boolean updateByEmail) {
        this.updateByEmail = updateByEmail;
    }

    public boolean isUpdateByEmail() {
        return updateByEmail;
    }


    @Override
    public boolean equals(Object obj) {
        //
        if(obj == null)
            return false;
        if(! (obj instanceof Spitter))
            return false;
        Spitter other = (Spitter) obj;
        return new EqualsBuilder().append(fullName, other.getFullName()).
                append(username, other.getUsername()).append(password, other.getPassword()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).append(fullName).append(username).append(password).toHashCode();
    }
}
