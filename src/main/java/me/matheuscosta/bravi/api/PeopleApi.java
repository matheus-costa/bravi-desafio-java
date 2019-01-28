package me.matheuscosta.bravi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.matheuscosta.bravi.pojo.People;
import me.matheuscosta.bravi.repository.PeopleRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/people")
public class PeopleApi {
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<People> register(@RequestBody People people){
		try {
			people = peopleRepository.save(people);
			return new ResponseEntity<>(people, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Iterable<People>> register(){
		try {
			Iterable<People> allPeoples = peopleRepository.findAll();
			return new ResponseEntity<>(allPeoples, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/{idPeople}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("idPeople") int idPeople){
		try {
			peopleRepository.deleteById(idPeople);
			return new ResponseEntity<>(true, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
