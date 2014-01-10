/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.businessentities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Commonuser implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Date birthday;
    private List<Plate> plateList;
    private Language fklanguage;

    public Commonuser(String string, String string2, Date d, String string3, String string4) {
    }

    public Commonuser(Integer id) {
        this.id = id;
    }

    public Commonuser(Integer id, String firstname, String lastname, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

	public Commonuser(String string, String string2, Date d,
			String string4, String string5, int language) {
		firstname = string;
		lastname = string2;
		birthday = d;
		email = string4;
		password = string5;
		fklanguage = new Language(language);
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Plate> getPlateList() {
        return plateList;
    }

    public void setPlateList(List<Plate> plateList) {
        this.plateList = plateList;
    }

    public Language getFklanguage() {
        return fklanguage;
    }

    public void setFklanguage(Language fklanguage) {
        this.fklanguage = fklanguage;
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
        if (!(object instanceof Commonuser)) {
            return false;
        }
        Commonuser other = (Commonuser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glassfish.movieplex7.entities.Commonuser[ id=" + id + " ]";
    }    
}