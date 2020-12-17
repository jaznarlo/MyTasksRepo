package com.dani;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.dani.Entity.Task;
import com.dani.dao.ITaskService;


@WebMvcTest(ToDoList.class)
@RunWith(SpringRunner.class)
public class ControllerTest {
	 
	@Autowired
	private MockMvc mock;
	
	@MockBean
	private ITaskService taskservice;
	
	@Test
	public void getAllTasks() throws Exception {
		when(taskservice.get_task()).thenReturn(
				Arrays.asList(new Task(1,"Hacer la comida","Pending"))
						
				);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/alltasks")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mock.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":1,\"descripcion\":\"Hacer la comida\",\"estado\":\"Pending\"}]"))
				.andReturn();

	}
	@Test
	public void get_task_byId() throws Exception {
		Task task = new Task(1,"Hacer la comida","Pending");
		Optional<Task> tarea = Optional.of(task);
		when(taskservice.get_task_byId(1)).thenReturn(tarea);
						
		RequestBuilder request = MockMvcRequestBuilders
				.get("/alltasks/1")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mock.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"descripcion\":\"Hacer la comida\",\"estado\":\"Pending\"}"))
				.andReturn();

	}
	@Test
	public void add_task() throws Exception {
		
		Task task = new Task(4,"Hacer la comida","Pending");
		
		when(taskservice.add_tarea(Mockito.any(Task.class))).thenReturn(task);
						
		RequestBuilder request_add = MockMvcRequestBuilders
				.post("/addtask")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\":4,\"descripcion\":\"Hacer la comida\",\"estado\":\"Pending\"}")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mock.perform(request_add)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":4,\"descripcion\":\"Hacer la comida\",\"estado\":\"Pending\"}"))
				.andReturn();
		System.out.println("Holi");

	}
	
}
