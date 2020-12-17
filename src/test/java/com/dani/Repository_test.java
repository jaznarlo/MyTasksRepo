package com.dani;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.dani.Entity.Task;

import com.dani.dao.TaskService;


@SpringBootTest
@RunWith(SpringRunner.class)

public class Repository_test {
	
	@Autowired
	private TaskService taskservice;

	@Test
	public void test_get_alltask() {
		List<Task> tareas = taskservice.get_task();
		assertEquals(3,tareas.size());
	}
	@Test
	public void test_get_task() {
		Optional<Task> tarea = taskservice.get_task_byId(1);
		assertEquals("Hacer la comida",tarea.get().getDescripcion());
		
	}

}
