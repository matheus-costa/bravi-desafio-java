package me.matheuscosta.bravi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.matheuscosta.bravi.pojo.People;

@Repository
public interface PeopleRepository extends CrudRepository<People, Integer> {

}
