package eus.birt.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.birt.dam.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
