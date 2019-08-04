package com.quintifi.todo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.quintifi.todo.domain.jpa.Todo;
import com.quintifi.todo.exceptions.ApiException;
import com.quintifi.todo.repository.jpa.TodoRepository;
import com.quintifi.todo.service.TodoService;

/**
 * 
 * @author nchopra
 *
 */
@Service
public class TodoServiceImpl implements TodoService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TodoServiceImpl.class);

	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public List<Todo> read() throws ApiException{
		List<Todo> todos = todoRepository.findAll();
		if(CollectionUtils.isEmpty(todos)) {
			LOGGER.error("Error while reading a list of todos");
			throw new ApiException("TD_404","Record Not Found!");
		}
		return todoRepository.findAll();
	}

	@Override
	public Todo create(Todo todo) throws ApiException{
		try {
			if(!ObjectUtils.isEmpty(todo)) {
				return todoRepository.save(todo);
			}
		}catch(Exception e) {
			LOGGER.error("Error while creating a todo");
			throw new ApiException("TD_303","Not a valid record");
		}
		return null;
	}

	@Override
	public boolean delete(Long todoId) throws ApiException{
		try{
			todoRepository.deleteById(todoId);
			return true;
		}catch(Exception e) {
			LOGGER.error("Error while deleting a todo");
			return false;
		}
	}

}
