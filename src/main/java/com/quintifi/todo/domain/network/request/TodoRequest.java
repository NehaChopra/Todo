package com.quintifi.todo.domain.network.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author nchopra
 */
public class TodoRequest implements Serializable {

	private static final long serialVersionUID = -253207988057358728L;

	@NotNull
	@NotEmpty
	private String task;
	@NotNull
	@NotEmpty	
	private String date;

	public TodoRequest() {
		super();
	}

	public TodoRequest(String task, String date) {
		this.task = task;
		this.date = date;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}