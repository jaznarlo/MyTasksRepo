package com.dani.dao;

import org.springframework.data.repository.CrudRepository;


import com.dani.Entity.Task;

public interface ITaskDao extends CrudRepository<Task,Long>{

}
