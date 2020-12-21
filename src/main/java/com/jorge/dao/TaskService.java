package com.jorge.dao;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorge.Entity.Task;

@Service
public class TaskService implements ITaskService {
	
	@Autowired
	private ITaskDao taskdao;
	/**
	 * @return
	 */

	public List<Task> get_task() {
		// TODO Auto-generated method stub
		return (List<Task>) taskdao.findAll();
	}
	
	public Task add_tarea(Task tarea) {
		return taskdao.save(tarea);
		
	}
	
	public void borrar_tarea(long id) {
		// TODO Auto-generated method stub
		taskdao.deleteById(id);
	}
	
	public long contar_tareas() {
		// TODO Auto-generated method stub
		return taskdao.count();
	}

	public Task update_task(long id, Task newtask) {
		Task old_task = taskdao.findById(id).get();
		old_task.setDescripcion(newtask.getDescripcion());
		old_task.setEstado(newtask.getEstado());
		taskdao.save(old_task);
		return old_task;
	}

	
	public Optional<Task> get_task_byId(long id) {
		return taskdao.findById(id);
	}
	

}
