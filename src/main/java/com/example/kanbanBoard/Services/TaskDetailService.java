package com.example.kanbanBoard.Services;

import com.example.kanbanBoard.Domains.Assignee;
import com.example.kanbanBoard.Domains.TaskDetails;
import com.example.kanbanBoard.Repositories.TaskDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskDetailService {

    @Autowired
    private TaskDetailRepository taskDetailRepository;


    public TaskDetails addTaskDetails(TaskDetails taskDetails) throws SQLIntegrityConstraintViolationException{
        if(taskDetails.getAssignee()==null || taskDetails.getCrnNo()==null || taskDetails.getCurrentStatus()==null || taskDetails.getTaskDescription()==null)
            return null;
        if(taskDetails.getTaskDescription().isEmpty() || taskDetails.getCurrentStatus().isEmpty() || taskDetails.getCrnNo().isEmpty() )
            return null;
        TaskDetails taskDetails1=taskDetailRepository.save(taskDetails);
           return taskDetails;
    }

    public List<TaskDetails> getTaskList(){

        List<TaskDetails> taskDetailsList=taskDetailRepository.findAll();
        return taskDetailsList;
    }
}
