package com.mana.spring.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "authority")
public class UserAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorityId")
    private long authorityId;

    @Column(name = "role")
    private String role;

    @ManyToOne()
    @JoinColumn(name = "authority_user")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "userId")
    @JsonIgnore
    private User user;

    public UserAuthority() {
    }

    public UserAuthority(User user,boolean admin) {
        this.user = user;
        if (admin)
            role = "ROLE_ADMIN";
        else
            role = "ROLE_CUSTOMER";
    }

    public long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(long authorityId) {
        this.authorityId = authorityId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
