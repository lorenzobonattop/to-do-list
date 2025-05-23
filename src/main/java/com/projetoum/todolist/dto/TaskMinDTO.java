package com.projetoum.todolist.dto;

import com.projetoum.todolist.models.Task;
import com.projetoum.todolist.models.TaskStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
