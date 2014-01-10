package com.example.businessentities;

import java.io.Serializable;

/**
 *
 * @author Quentin
 */
public class PlatetofoodPK implements Serializable {
    private int fkplate;
    private int fkfood;

    public PlatetofoodPK() {
    }

    public PlatetofoodPK(int fkplate, int fkfood) {
        this.fkplate = fkplate;
        this.fkfood = fkfood;
    }

    public int getFkplate() {
        return fkplate;
    }

    public void setFkplate(int fkplate) {
        this.fkplate = fkplate;
    }

    public int getFkfood() {
        return fkfood;
    }

    public void setFkfood(int fkfood) {
        this.fkfood = fkfood;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fkplate;
        hash += (int) fkfood;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlatetofoodPK)) {
            return false;
        }
        PlatetofoodPK other = (PlatetofoodPK) object;
        if (this.fkplate != other.fkplate) {
            return false;
        }
        if (this.fkfood != other.fkfood) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glassfish.movieplex7.entities.PlatetofoodPK[ fkplate=" + fkplate + ", fkfood=" + fkfood + " ]";
    }
    
}

