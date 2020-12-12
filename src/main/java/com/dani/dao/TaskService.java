package com.dani.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dani.Entity.Task;

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
	
	
	

}
