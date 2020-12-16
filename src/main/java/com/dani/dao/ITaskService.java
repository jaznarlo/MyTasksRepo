package com.dani.dao;

import java.util.List;
import java.util.Optional;

import com.dani.Entity.Task;

public interface ITaskService {
	public List<Task> get_task();
	public Optional<Task> get_task_byId(long id);
	public Task add_tarea(Task tarea);
	public Task update_task(long id, Task tarea);
	public void borrar_tarea(long id);
	public long contar_tareas();
	

}
