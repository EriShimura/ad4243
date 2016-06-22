package com.application.ad4243.model;

import javax.jdo.annotations.*;
import java.net.URL;

/**
*
* @author g13943se
*/
@PersistenceCapable(identityType =IdentityType.APPLICATION)
public class User {
	/* IDとしてnameを使う。
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
   private Long userId;
	*/
	
	/* Googleがやってくれるならパスワードはいらない
	@Persistent
   private String pass;
   */
	
	@PrimaryKey
   private String name;
	
	@Persistent
   private int point;

   public User(/*Long userId, String pass,*/String name,int point){
       //this.userId = userId;
       //this.pass = pass;
       this.name = name;
       this.point = point;
   }
  // public Long getUserId(){ return userId; }
   //public String getPass(){ return pass; }
   public String getName(){ return name; }
   public int getPoint(){ return point; }
   public void setPoint(int point){ this.point = point; }
}
