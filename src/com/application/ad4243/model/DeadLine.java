package com.application.ad4243.model;

import java.sql.Date;
import javax.jdo.annotations.*;

import com.google.appengine.api.search.query.QueryParser.primitive_return;

/**
 *
 * @author g13943se
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class DeadLine {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	long deadlineId;
	
	@Persistent
    int userId;
	
	@Persistent
    Date deadline;
	
	@Persistent
    String details;
	
    public DeadLine(int userId,Date deadline,String details){
        this.userId = userId;
        this.deadline = deadline;
        this.details = details;
        deadlineId = userId * (int) details.charAt(0); // wei!!!!!!
    }
    public String getDetails(){ return details; }
    public long getDeadlineId(){ return deadlineId; }
    public int getUserId(){ return userId; }
    public Date getDeadline(){ return deadline; }
    public void setDetails(String details){ this.details = details; }
}
