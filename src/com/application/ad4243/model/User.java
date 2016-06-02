package com.application.ad4243.model;

/**
*
* @author g13943se
*/
public class User {
   private int userId;
   private String pass;
   private String name;
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
