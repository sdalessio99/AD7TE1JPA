package eus.birt.dam.domain;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="book")
public class Book implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String title;
	
	@Column(name="publication_date")
	private LocalDate publDate;
	
	@Column
	private String genre;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn (name="id")
	private Author author;
	
	public Book(Long id, String title, LocalDate publDate, String genre, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.publDate = publDate;
		this.genre = genre;
		this.author = author;
	}

}
