package com.jorge.dao;

import org.springframework.data.repository.CrudRepository;

import com.jorge.Entity.Task;

public interface ITaskDao extends CrudRepository<Task,Long>{

}
