package com.strawhat.shiro.pojo;


public class Position {

  private long id;
  private String positionNo;
  private String positionName;
  private double salary;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getPositionNo() {
    return positionNo;
  }

  public void setPositionNo(String positionNo) {
    this.positionNo = positionNo;
  }


  public String getPositionName() {
    return positionName;
  }

  public void setPositionName(String positionName) {
    this.positionName = positionName;
  }


  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

}
