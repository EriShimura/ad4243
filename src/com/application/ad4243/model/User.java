package com.application.ad4243.model;

import javax.jdo.annotations.*;
import java.net.URL;

/**
*
* @author g13943se
*/
@PersistenceCapable(identityType =IdentityType.APPLICATION)
public class User {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
   private int userId;
	
	@Persistent
   private String pass;
	
	@Persistent
   private String name;
	
	@Persistent
   private int point;

   public User(int userId,String pass,String name,int point){
       this.userId = userId;
       this.pass = pass;
       this.name = name;
       this.point = point;
   }
   public int getUserId(){ return userId; }
   public String getPass(){ return pass; }
   public String getName(){ return name; }
   public int getPoint(){ return point; }
   public void setPoint(int point){ this.point = point; }
}
