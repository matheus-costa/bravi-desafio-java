package me.matheuscosta.bravi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.matheuscosta.bravi.pojo.Contact;
import me.matheuscosta.bravi.pojo.People;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {
	public List<Contact> findByPeople(People people);

}
