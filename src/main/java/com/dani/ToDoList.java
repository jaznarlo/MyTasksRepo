package com.dani;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dani.Entity.Task;
import com.dani.dao.ITaskService;

@RestController
@RequestMapping(value="todolist")

public class ToDoList {
	
	@Autowired
	private ITaskService taskservice;
	
	@GetMapping(value="tasks")
	public List<Task> getTask(){
		return taskservice.get_task();
	}
}
