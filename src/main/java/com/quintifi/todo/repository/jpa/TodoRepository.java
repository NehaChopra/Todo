package com.quintifi.todo.repository.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quintifi.todo.domain.jpa.Todo;

/**
 * 
 * @author nchopra
 *
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
	
	Optional<Todo> findByTask(String task);
	
}