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

import eus.birt.dam.domain.Book;
import eus.birt.dam.repository.AuthorRepository;
import eus.birt.dam.repository.BookRepository;

@CrossOrigin (origins= {"http://localhost:8080"})
@RestController
@RequestMapping ("api/books")
public class BookController {

	@Autowired
	BookRepository bookRep;
	
	@Autowired
	AuthorRepository authorRep;
		
	@GetMapping({"/",""})
	public List <Book> index() {
		return bookRep.findAll();
	}
	
	@GetMapping("/{id}")
	public Book show(@PathVariable("id") Long id) {
		return bookRep.findById(id).orElse(null);
	}
	
	@PostMapping({"","/"})
	@ResponseStatus (HttpStatus.CREATED)
	public Book create(@RequestBody Book book) {
		return bookRep.save(book);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Book update(@RequestBody Book book, @PathVariable("id") Long id) {
		Book tempBook = bookRep.findById(id).orElse(null);
		
		tempBook.setTitle(book.getTitle());
		tempBook.setPublDate(book.getPublDate());
		tempBook.setGenre(book.getGenre());
		tempBook.setAuthor(book.getAuthor());
		
		return bookRep.save(tempBook);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		bookRep.deleteById(id);
	}
	
}