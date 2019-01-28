package me.matheuscosta.bravi.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "people")
public class People {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;
    
    @OneToMany(mappedBy = "people", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Contact> contacts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
    
}
