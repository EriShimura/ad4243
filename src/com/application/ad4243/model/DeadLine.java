package com.application.ad4243.model;

import java.sql.Date;

/**
 *
 * @author g13943se
 */
public class DeadLine {
    int userId;
    Date deadline;
    String details;
    public DeadLine(int userId,Date deadline,String details){
        this.userId = userId;
        this.deadline = deadline;
        this.details = details;
    }
    public String getDetails(){ return details; }
}
