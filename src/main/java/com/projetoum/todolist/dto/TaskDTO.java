package com.projetoum.todolist.dto;

import com.projetoum.todolist.entities.Task;
import com.projetoum.todolist.entities.TaskStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TaskDTO(Task entity){
        BeanUtils.copyProperties(entity, this);
    }
}
