package com.dc.bean;

public class Teacher
{
	private String teacherName;
	private String teacherAccount;
	private String teacherPassword;
	

	public Teacher()
	{
		 
	}


	public String getTeacherName()
	{
		return teacherName;
	}


	public void setTeacherName(String teacherName)
	{
		this.teacherName = teacherName;
	}


	public String getTeacherAccount()
	{
		return teacherAccount;
	}


	public void setTeacherAccount(String teacherAccount)
	{
		this.teacherAccount = teacherAccount;
	}


	public String getTeacherPassword()
	{
		return teacherPassword;
	}


	public void setTeacherPassword(String teacherPassword)
	{
		this.teacherPassword = teacherPassword;
	}


	public Teacher(String teacherName, String teacherAccount, String teacherPassword)
	{
		super();
		this.teacherName = teacherName;
		this.teacherAccount = teacherAccount;
		this.teacherPassword = teacherPassword;
	}
	@Override
	public String toString()
	{
		return "Teacher [teacherName=" + teacherName + ", teacherAccount=" + teacherAccount
				+ ", teacherPassword=" + teacherPassword + "]";
	}

}
