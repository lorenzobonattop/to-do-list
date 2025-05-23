package com.projetoum.todolist.dto;

import com.projetoum.todolist.entities.Task;
import com.projetoum.todolist.entities.TaskStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TaskMinDTO {
    private Long id;
    private String title;
    private TaskStatus status;
    private String createdBy;
    private LocalDateTime createdAt;

    public TaskMinDTO(Task entity){
        id = entity.getId();
        title = entity.getTitle();
        status = entity.getStatus();
        createdBy = entity.getCreatedBy();
        createdAt = entity.getCreatedAt();
    }
}
