package com.example.kanbanBoard.Controllers;

import com.example.kanbanBoard.DTO.Status;
import com.example.kanbanBoard.Domains.Assignee;
import com.example.kanbanBoard.Domains.TaskDetails;
import com.example.kanbanBoard.Services.TaskDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/task")
public class TaskDetailController {


    @Autowired
    private TaskDetailService taskDetailService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity addTask(@RequestBody TaskDetails taskDetails){
        TaskDetails taskDetails1=null;

        if(taskDetails==null){
            return new ResponseEntity(new Status("Empty data"), HttpStatus.NOT_ACCEPTABLE);
        }

        try {
            taskDetails1=taskDetailService.addTaskDetails(taskDetails);
        } catch(SQLIntegrityConstraintViolationException e){
            return  new ResponseEntity(new Status("CRN no should be unique"),HttpStatus.CONFLICT);
        }


        if(taskDetails1==null) {
            return new ResponseEntity(new Status("Fill all the enteries"),HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity(new Status("Task Added"),HttpStatus.OK);
    }

    @RequestMapping(value = "/getTaskList",method = RequestMethod.GET)
    public ResponseEntity getTaskList(){
        List<TaskDetails> taskDetailsList=taskDetailService.getTaskList();
        if(taskDetailsList==null)
            return new ResponseEntity(new Status("Empty List"), HttpStatus.NO_CONTENT);
        return new ResponseEntity(taskDetailsList,HttpStatus.OK);
    }
}
