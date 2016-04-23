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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author arrais
 */
@Entity
@Table(name = "User")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String passWord;
    private String type;
    private int phone;
    private String location;
    
    @OneToMany(mappedBy = "User", cascade={CascadeType.ALL}, orphanRemoval=true)
    private List<Contact> contactList;
    
    @OneToMany(mappedBy = "User", cascade={CascadeType.ALL}, orphanRemoval=true)
    private List<Service> serviceList;
    
    @OneToMany(mappedBy = "User", cascade={CascadeType.ALL}, orphanRemoval=true)
    private List<ContactService> contactServiceList;
    
    @OneToOne(mappedBy = "User")
    private Rating rating;

    public User() {
        this.contactList = new ArrayList<>();
        this.serviceList = new ArrayList<>();
        this.contactServiceList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    @XmlTransient
    @JsonIgnore
    public List<Contact> getcontactList() {
        return contactList;
    }

    public void setcontactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
     @XmlTransient
    @JsonIgnore
    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
    @XmlTransient
    @JsonIgnore
    public List<ContactService> getContactServiceList() {
        return contactServiceList;
    }

    public void setContactServiceList(List<ContactService> contactServiceList) {
        this.contactServiceList = contactServiceList;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
    
    
    public void addContact(Contact contact){
        contactList.add(contact);
    }
    
    public void removeContact(Contact contact){
        contactList.remove(contact);
    }
    
     public void addService(Service service){
        serviceList.add(service);
    }
    
    public void removeService(Service service){
        serviceList.remove(service);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.passWord);
        hash = 29 * hash + Objects.hashCode(this.type);
        hash = 29 * hash + this.phone;
        hash = 29 * hash + Objects.hashCode(this.location);
        hash = 29 * hash + Objects.hashCode(this.contactList);
        hash = 29 * hash + Objects.hashCode(this.serviceList);
        hash = 29 * hash + Objects.hashCode(this.contactServiceList);
        hash = 29 * hash + Objects.hashCode(this.rating);
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
        final User other = (User) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.passWord, other.passWord)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (this.phone != other.phone) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.contactList, other.contactList)) {
            return false;
        }
        if (!Objects.equals(this.serviceList, other.serviceList)) {
            return false;
        }
        if (!Objects.equals(this.contactServiceList, other.contactServiceList)) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        return true;
    }
   
    
    
    
    
}
