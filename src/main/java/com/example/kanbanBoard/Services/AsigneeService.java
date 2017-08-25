package com.example.kanbanBoard.Services;

import com.example.kanbanBoard.Domains.Assignee;
import com.example.kanbanBoard.Repositories.AsigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsigneeService {
    @Autowired
    private AsigneeRepository asigneeRepository;

    public List<Assignee> getAsigneeList(){

        List<Assignee> assigneeList=asigneeRepository.findAll();
        return assigneeList;
    }
}
