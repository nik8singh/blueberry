package com.mana.spring.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "password_reset")
public class PasswordReset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "password_reset_id")
    private long passwordResetId;

    @Column(name = "password_reset_expiration")
    private Date expiration;

    @Column(name = "password_reset_active")
    private boolean active;

    @Column(name = "password_reset_token")
    private String token;

    @ManyToOne()
    @JoinColumn(name = "passwordReset_user")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "userId")
    private User passwordResetUser;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date updatedDate;

    public PasswordReset() {
    }

    public long getPasswordResetId() {
        return passwordResetId;
    }

    public void setPasswordResetId(long passwordResetId) {
        this.passwordResetId = passwordResetId;
    }

    public User getPasswordResetUser() {
        return passwordResetUser;
    }

    public void setPasswordResetUser(User passwordResetUser) {
        this.passwordResetUser = passwordResetUser;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "PasswordReset{" +
                "passwordResetId=" + passwordResetId +
                ", expiration=" + expiration +
                ", active=" + active +
                ", token=" + token +
                ", passwordResetUser=" + passwordResetUser +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
