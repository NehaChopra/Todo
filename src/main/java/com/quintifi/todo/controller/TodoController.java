package com.quintifi.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quintifi.todo.domain.jpa.Todo;
import com.quintifi.todo.service.TodoService;

/**
 * 
 * @author nchopra
 *
 */
@RestController
public class TodoController {
	
	@Autowired
    TodoService todoService;

	@RequestMapping(value = "/todos", method = { RequestMethod.POST })
	public ResponseEntity<?> create(@RequestBody Todo todoRequest ) {
		Todo todo = todoService.create(todoRequest);
        return ResponseEntity.ok(todo);
	}

	@RequestMapping(value = "/todos", method = { RequestMethod.GET })
	public ResponseEntity<?> read() {
		List<Todo> todo = todoService.read();
        return ResponseEntity.ok(todo);
	}

	@RequestMapping(value = "/todo/{id}", method = { RequestMethod.DELETE })
	public ResponseEntity<?> delete(@PathVariable(required = true) Long id) {
		boolean status = todoService.delete(id);
        return ResponseEntity.ok(status);
	}
}
