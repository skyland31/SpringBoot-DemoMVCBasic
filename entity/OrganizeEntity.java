package com.example.demomvc.entity;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "organize", schema = "batch_cron")
public class OrganizeEntity {
    private int orgId;
    private String orgName;
    private String address;
    private String tel;

    @Id
    @Column(name = "org_id")
    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    @Basic
    @Column(name = "org_name")
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizeEntity that = (OrganizeEntity) o;
        return orgId == that.orgId &&
                Objects.equals(orgName, that.orgName) &&
                Objects.equals(address, that.address) &&
                Objects.equals(tel, that.tel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orgId, orgName, address, tel);
    }


}
