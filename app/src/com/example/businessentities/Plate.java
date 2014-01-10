package com.example.businessentities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Plate implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Commonuser fkcommonuser;
    private List<Platetofood> platetofoodList = new ArrayList<Platetofood>();

    public Plate() {
    }

    public Plate(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Commonuser getFkcommonuser() {
        return fkcommonuser;
    }

    public void setFkcommonuser(Commonuser fkcommonuser) {
        this.fkcommonuser = fkcommonuser;
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
        if (!(object instanceof Plate)) {
            return false;
        }
        Plate other = (Plate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    public void addPlateToFood(Platetofood pf)
    {
    	platetofoodList.add(pf);
    }

    @Override
    public String toString() {
        return "org.glassfish.movieplex7.entities.Plate[ id=" + id + " ]";
    }    
}