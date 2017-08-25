package com.example.kanbanBoard.Domains;

import javax.persistence.*;

@Entity
@Table(name = "assignee")
public class Assignee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="asignee_Id")
    private Long assignee;

    @Column(name="assignee_name")
    private String  assigneeName;

    @Column(name="username",unique = true)
    private String username;

    public Assignee() {
    }

    public Long getAssignee() {
        return assignee;
    }

    public void setAssignee(Long assignee) {
        this.assignee = assignee;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
