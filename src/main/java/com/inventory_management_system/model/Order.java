package com.inventory_management_system.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "itemOrderMapping")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "userid")
    private long userid;

    @Column(name = "orderid")
    private long orderid;

    @Column(name = "itemid")
    private long itemid;

    public long getUserId() {
        return userid;
    }

    public void setUserid(long id) {
        this.userid = id;
    }

    public long getOrderId() {
        return orderid;
    }

    public void setOrderid(long id) {
        this.orderid = id;
    }


    public long getItemId() {
        return itemid;
    }

    public void setItemid(long id) {
        this.itemid = id;
    }


}
