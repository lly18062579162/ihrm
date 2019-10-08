package com.ihrm.domain.system;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "bs_city")
public class City implements Serializable {

    @Id
    private String id;
    private String name;
    private Date createTime;

    public void setId(String value) {
        this.id = value;
    }
    public String getId() {
        return this.id;
    }
    public void setName(String value) {
        this.name = value;
    }
    public String getName() {
        return this.name;
    }
    public void setCreateTime(Date value) {
        this.createTime = value;
    }
    public Date getCreateTime() {
        return this.createTime;
    }
}
