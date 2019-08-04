package com.quintifi.todo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.quintifi.todo.domain.jpa.Todo;
import com.quintifi.todo.exceptions.ApiException;

/**
 * 
 * @author nchopra
 *
 */
public interface TodoService {

	List<Todo> read() throws ApiException;

	@Transactional
	Todo create(Todo todo) throws ApiException;

	@Transactional
	boolean delete(Long todoId) throws ApiException;
}
