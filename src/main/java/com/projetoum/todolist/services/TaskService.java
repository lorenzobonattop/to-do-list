package com.projetoum.todolist.services;

import com.projetoum.todolist.dto.TaskDTO;
import com.projetoum.todolist.dto.TaskMinDTO;
import com.projetoum.todolist.entities.Task;
import com.projetoum.todolist.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional(readOnly = true)
    public List<TaskMinDTO> findAll(){
        return taskRepository.findAll()
                .stream()
                .map(TaskMinDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public TaskDTO findById(Long id){
        return taskRepository.findById(id)
                .map(TaskDTO::new)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " +id));
    }

    public TaskDTO insert(TaskDTO dto){
        Task entity = new Task();
        BeanUtils.copyProperties(dto, entity);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        return new TaskDTO(taskRepository.save(entity));
    }

    public TaskDTO update(Long id, TaskDTO dto){
        Task entity = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + id));

        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        entity.setCreatedBy(dto.getCreatedBy()); // se for editável
        entity.setUpdatedAt(LocalDateTime.now());

        return new TaskDTO(taskRepository.save(entity));
    }

    public void delete(Long id){
        Task entity = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + id));
        taskRepository.delete(entity);
    }
}
