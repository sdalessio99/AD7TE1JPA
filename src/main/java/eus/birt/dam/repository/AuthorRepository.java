package eus.birt.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.birt.dam.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	
}
