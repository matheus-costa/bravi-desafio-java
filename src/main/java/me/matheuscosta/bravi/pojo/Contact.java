package me.matheuscosta.bravi.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "contact")
public class Contact {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "people_id")
	private People people;
	
	private String typeContact;
	
	private String valueContact;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public String getTypeContact() {
		return typeContact;
	}

	public void setTypeContact(String typeContact) {
		this.typeContact = typeContact;
	}

	public String getValueContact() {
		return valueContact;
	}

	public void setValueContact(String valueContact) {
		this.valueContact = valueContact;
	}
	
}
