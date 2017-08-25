package com.example.kanbanBoard.Controllers;

import com.example.kanbanBoard.DTO.Status;
import com.example.kanbanBoard.Domains.Assignee;
import com.example.kanbanBoard.Services.AsigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/asignee")
public class AsigneeController {

    @Autowired
    private AsigneeService  asigneeService;

    @RequestMapping(value = "/getAsigneeList",method = RequestMethod.GET)
    public ResponseEntity getAsigneeList(){
        List<Assignee> assigneeList=asigneeService.getAsigneeList();
        if(assigneeList==null)
            return new ResponseEntity(new Status("Empty List"), HttpStatus.NO_CONTENT);
        return new ResponseEntity(assigneeList,HttpStatus.OK);
    }
}
