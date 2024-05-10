package eus.birt.dam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.dam.domain.Author;
import eus.birt.dam.repository.AuthorRepository;

@CrossOrigin (origins= {"http://localhost:8080"})
@RestController
@RequestMapping ("api/authors")
public class AuthorController {

@Autowired
AuthorRepository authorRep;
	
	@GetMapping({"/",""})
	public List <Author> index() {
	return authorRep.findAll();
	}
	
	@GetMapping("/{id}")
	public Author show(@PathVariable("id") Long id) {
		return authorRep.findById(id).orElse(null);
	}
	
	@PostMapping({"/",""})
	@ResponseStatus (HttpStatus.CREATED)
	public Author create(@RequestBody Author author) {
		return authorRep.save(author);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Author update(@RequestBody Author author, @PathVariable("id") Long id) {
		Author tempAuthor = authorRep.findById(id).orElse(null);
		
		tempAuthor.setFirstName(author.getFirstName());
		tempAuthor.setLastName(author.getLastName());
		tempAuthor.setNationality(author.getNationality());
		tempAuthor.setBirthDate(author.getBirthDate());
		return authorRep.save(tempAuthor);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		authorRep.deleteById(id);
	}
	
}