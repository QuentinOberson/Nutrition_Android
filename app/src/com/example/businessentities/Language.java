package com.example.businessentities;

import java.io.Serializable;
import java.util.List;

public class Language implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String description;
    private List<Commonuser> commonuserList;

    public Language() {
    }

    public Language(Integer id) {
        this.id = id;
    }

    public Language(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Commonuser> getCommonuserList() {
        return commonuserList;
    }

    public void setCommonuserList(List<Commonuser> commonuserList) {
        this.commonuserList = commonuserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Language)) {
            return false;
        }
        Language other = (Language) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glassfish.movieplex7.entities.Language[ id=" + id + " ]";
    }    
}