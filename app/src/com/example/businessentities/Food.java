package com.example.businessentities;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Quentin
 */
public class Food implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String enDefinition;
    private String deDefinition;
    private String frDefinition;
    private Integer nutritiveValue;
    private List<Platetofood> platetofoodList;

    public Food() {
    }

    public Food(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnDefinition() {
        return enDefinition;
    }

    public void setEnDefinition(String enDefinition) {
        this.enDefinition = enDefinition;
    }

    public String getDeDefinition() {
        return deDefinition;
    }

    public void setDeDefinition(String deDefinition) {
        this.deDefinition = deDefinition;
    }

    public String getFrDefinition() {
        return frDefinition;
    }

    public void setFrDefinition(String frDefinition) {
        this.frDefinition = frDefinition;
    }

    public Integer getNutritiveValue() {
        return nutritiveValue;
    }

    public void setNutritiveValue(Integer nutritiveValue) {
        this.nutritiveValue = nutritiveValue;
    }

    public List<Platetofood> getPlatetofoodList() {
        return platetofoodList;
    }

    public void setPlatetofoodList(List<Platetofood> platetofoodList) {
        this.platetofoodList = platetofoodList;
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
        if (!(object instanceof Food)) {
            return false;
        }
        Food other = (Food) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return enDefinition;
    }
    
}
