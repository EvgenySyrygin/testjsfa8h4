package com.kg.testjsfa8h4.entity;
// Generated Dec 8, 2016 10:35:31 AM by Hibernate Tools 3.2.1.GA



/**
 * OwnType generated by hbm2java
 */
public class OwnType  implements java.io.Serializable {


     private Integer id;
     private String ownType;

    public OwnType() {
    }

    public OwnType(String ownType) {
       this.ownType = ownType;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getOwnType() {
        return this.ownType;
    }
    
    public void setOwnType(String ownType) {
        this.ownType = ownType;
    }




}

