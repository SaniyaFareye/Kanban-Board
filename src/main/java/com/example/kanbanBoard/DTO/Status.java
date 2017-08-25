package com.example.kanbanBoard.DTO;

/**
 * Created by xplode on 10/8/17.
 */
public class Status
{
    String message;
    public Status(String message)
    {
        this.message=message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
