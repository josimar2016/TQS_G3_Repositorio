/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ua.encontreja.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author arrais
 */
@Entity
@Table(name="Service")
public class Service implements Serializable {

    public Service() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }
            
    private String title;
    private String description;
    private double hourPrice;
    private double feePrice;
    //falta adicionar a imagem
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Category category;
    
    @OneToMany(mappedBy = "Service", cascade={CascadeType.ALL}, orphanRemoval=true)
    private List<Contact> contactList;
    
    @OneToMany(mappedBy = "Service", cascade={CascadeType.ALL}, orphanRemoval=true)
    private List<Rating> ratingList;

    public Service(List<Contact> contactList, List<Rating> ratingList) {
        this.contactList = new ArrayList<>();
        this.ratingList = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(double hourPrice) {
        this.hourPrice = hourPrice;
    }

    public double getFeePrice() {
        return feePrice;
    }

    public void setFeePrice(double feePrice) {
        this.feePrice = feePrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    @XmlTransient
    @JsonIgnore
    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
    
    @XmlTransient
    @JsonIgnore
    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }
    
    public void addContactList(Contact contact){
        contactList.add(contact);
    }
    
    public void removeContactList(Contact contact){
        contactList.remove(contact);
    }
    
    public void addRating(Rating rating){
        ratingList.add(rating);
    }
    
    public void removeRating(Rating rating){
        ratingList.remove(rating);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.title);
        hash = 41 * hash + Objects.hashCode(this.description);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.hourPrice) ^ (Double.doubleToLongBits(this.hourPrice) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.feePrice) ^ (Double.doubleToLongBits(this.feePrice) >>> 32));
        hash = 41 * hash + Objects.hashCode(this.user);
        hash = 41 * hash + Objects.hashCode(this.category);
        hash = 41 * hash + Objects.hashCode(this.contactList);
        hash = 41 * hash + Objects.hashCode(this.ratingList);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Service other = (Service) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (Double.doubleToLongBits(this.hourPrice) != Double.doubleToLongBits(other.hourPrice)) {
            return false;
        }
        if (Double.doubleToLongBits(this.feePrice) != Double.doubleToLongBits(other.feePrice)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.contactList, other.contactList)) {
            return false;
        }
        if (!Objects.equals(this.ratingList, other.ratingList)) {
            return false;
        }
        return true;
    }
    
    
    
}
