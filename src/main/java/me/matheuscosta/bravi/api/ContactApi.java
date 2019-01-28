package me.matheuscosta.bravi.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.matheuscosta.bravi.pojo.Contact;
import me.matheuscosta.bravi.pojo.People;
import me.matheuscosta.bravi.repository.ContactRepository;
import me.matheuscosta.bravi.repository.PeopleRepository;

@Controller
@CrossOrigin
@RestController
@RequestMapping("/api/contact")
public class ContactApi {
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	@RequestMapping(value = "/{idPeople}", method = RequestMethod.POST)
	public ResponseEntity<Contact> save(@PathVariable("idPeople") int idPeople, @RequestBody Contact contact){
		try {
			Optional<People> people = peopleRepository.findById(idPeople);
			if(!people.isPresent()) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			contact.setPeople(people.get());
			contact = contactRepository.save(contact);
			return new ResponseEntity<>(contact, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/{idPeople}", method = RequestMethod.GET)
	public ResponseEntity<List<Contact>> list(@PathVariable("idPeople") int idPeople){
		try {
			Optional<People> people = peopleRepository.findById(idPeople);
			if(!people.isPresent()) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			List<Contact> contactsPeople = contactRepository.findByPeople(people.get());
			return new ResponseEntity<>(contactsPeople, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/{idContact}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("idContact") int idContact){
		try {
			contactRepository.deleteById(idContact);
			return new ResponseEntity<>(true, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
