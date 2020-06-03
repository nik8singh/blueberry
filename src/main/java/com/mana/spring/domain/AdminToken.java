package com.mana.spring.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "admin_token")
public class AdminToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "admin_token", nullable = false)
    private String adminToken;

    @Column(name = "expiration", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date expiration;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    public AdminToken() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdminToken() {
        return adminToken;
    }

    public void setAdminToken(String adminToken) {
        this.adminToken = adminToken;
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

    @Override
    public String toString() {
        return "AdminToken{" +
                "id=" + id +
                ", adminToken='" + adminToken + '\'' +
                ", expiration=" + expiration +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
