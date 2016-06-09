package com.application.ad4243.model;

import java.sql.Date;
import javax.jdo.annotations.*;

/**
 *
 * @author g13943se
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class DeadLine {
	
	@PrimaryKey
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
    }
    public String getDetails(){ return details; }
}
