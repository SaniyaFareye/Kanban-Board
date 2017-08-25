package com.example.kanbanBoard.Domains;

import javax.persistence.*;

@Entity
@Table(name = "taskDetails")
public class TaskDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="task_Id")
    private Long taskID;

    @Column(name="crn_no",unique = true)
        private String  crnNo;

    @Column(name="current_status")
    private String currentStatus;

    @Column(name="task_description")
    private String taskDescription;



    @OneToOne
    @JoinColumn(name="asignee_Id",insertable=true,updatable=true,nullable = false)
    private Assignee assignee;

    public TaskDetails() {
    }

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    public String getCrnNo() {
        return crnNo;
    }

    public void setCrnNo(String crnNo) {
        this.crnNo = crnNo;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }
}
