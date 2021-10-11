package br.com.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.rest.model.Person;

@Service
public class PersonSercive {

	private final AtomicLong counter = new AtomicLong();

	public Person create(Person person) {
		return person;
	}

	public Person update(Person person) {
		return person;
	}
	
	public void delete(Long id) {
	}

	public Person findById(String ig) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Luciano");
		person.setLastName("de Paula");
		person.setAddress("Airuoca 275, Dom Bosco, Betim - MG");
		person.setGender("Male");
		return person;
	}

	public List<Person> findAll() {

		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name" + i);
		person.setLastName("Last name" + i);
		person.setAddress("Some Address - MG" + i);
		person.setGender("Male");
		return person;
	}

}
