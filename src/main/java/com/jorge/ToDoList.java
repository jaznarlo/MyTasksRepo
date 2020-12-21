package com.jorge;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.Entity.Task;
import com.jorge.dao.ITaskService;

import antlr.TokenStreamRetryException;

@RestController
public class ToDoList {
	
	@Autowired
	private ITaskService taskservice;
	
	
	
	@RequestMapping(value="/alltasks", method = RequestMethod.GET)
	public List<Task> getTask(){
		return taskservice.get_task();
	}
	@RequestMapping(value="/task/{id}", method = RequestMethod.GET)
	public Optional<Task> getTask_byId(@PathVariable Long id){
		return taskservice.get_task_byId(id);
	}
	@PostMapping(value="/task") 
	public Task addTask(@RequestBody Task tarea) {
		return taskservice.add_tarea(tarea);
	}
	@PutMapping(value ="/task/{id}")
	public Task updateTask(@RequestBody Task newtarea,@PathVariable Long id) {
		Task task = taskservice.update_task(id, newtarea);
		return task;
	}
	@DeleteMapping(value="/task/{id}") 
	public void del_task(@PathVariable Long id) {
		taskservice.borrar_tarea(id);
	}
	
	
}
