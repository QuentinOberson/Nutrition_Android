package com.example.businessentities;

import java.io.Serializable;

public class Platetofood implements Serializable {
    private static final long serialVersionUID = 1L;
    protected PlatetofoodPK platetofoodPK;
    private Integer quantity;
    private Plate plate;
    private Food food;

    public Platetofood(Food food, Integer integer, Plate plate) {
    	this.food = food;
    	this.quantity = integer;
    	this.plate = plate;
    }

    public Platetofood(PlatetofoodPK platetofoodPK) {
        this.platetofoodPK = platetofoodPK;
    }

    public Platetofood(int fkplate, int fkfood) {
        this.platetofoodPK = new PlatetofoodPK(fkplate, fkfood);
    }

    public Platetofood(Food f) {
		this.food = f;
	}

	public Platetofood(Food f, Integer quantity) {
		this.food = f;
		this.quantity = quantity;
	}

	public PlatetofoodPK getPlatetofoodPK() {
        return platetofoodPK;
    }

    public void setPlatetofoodPK(PlatetofoodPK platetofoodPK) {
        this.platetofoodPK = platetofoodPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Plate getPlate() {
        return plate;
    }

    public void setPlate(Plate plate) {
        this.plate = plate;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (platetofoodPK != null ? platetofoodPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Platetofood)) {
            return false;
        }
        Platetofood other = (Platetofood) object;
        if ((this.platetofoodPK == null && other.platetofoodPK != null) || (this.platetofoodPK != null && !this.platetofoodPK.equals(other.platetofoodPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glassfish.movieplex7.entities.Platetofood[ platetofoodPK=" + platetofoodPK + " ]";
    }    
}