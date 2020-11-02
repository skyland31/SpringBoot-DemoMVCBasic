package com.example.demomvc.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "batch_cron")
public class UserEntity {
    private int userId;
    private String name;
    private String lastName;
    private String tel;
    private String email;
    private Timestamp createDate;
    private Integer orgId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "org_id")
    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(tel, that.tel) &&
                Objects.equals(email, that.email) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(orgId, that.orgId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, lastName, tel, email, createDate, orgId);
    }

    private OrganizeEntity organizeEntity;

    @ManyToOne(/*Fetch = FetchType.EAGER*/)
    @JoinColumn(name = "org_id", insertable = false, updatable = false)
    public OrganizeEntity getOrganizeEntity() {
        return organizeEntity;
    }

    public void setOrganizeEntity(OrganizeEntity organizeEntity) {
        this.organizeEntity = organizeEntity;
    }
}

