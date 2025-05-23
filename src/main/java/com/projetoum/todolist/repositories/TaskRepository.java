package com.projetoum.todolist.repositories;

import com.projetoum.todolist.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository <Task, Long>{
}
