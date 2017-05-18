package com.dc.bean;

public class Student
{
	private String studentAccount;
	private String studentName;
	private String studentSex;
	private String studentPassword;
	public String getStudentAccount()
	{
		return studentAccount;
	}
	public void setStudentAccount(String studentAccount)
	{
		this.studentAccount = studentAccount;
	}
	public String getStudentPassword()
	{
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword)
	{
		this.studentPassword = studentPassword;
	}
	public String getStudentName()
	{
		return studentName;
	}
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}
	public String getStudentSex()
	{
		return studentSex;
	}
	public void setStudentSex(String studentSex)
	{
		this.studentSex = studentSex;
	}
	public Student(String studentAccount, String studentName, String studentSex,
			String studentPassword)
	{
		super();
		this.studentAccount = studentAccount;
		this.studentName = studentName;
		this.studentSex = studentSex;
		this.studentPassword = studentPassword;
	}
	@Override
	public String toString()
	{
		return "Student [studentAccount=" + studentAccount + ", studentName=" + studentName
				+ ", studentSex=" + studentSex + ", studentPassword=" + studentPassword + "]";
	}
	
	
}
