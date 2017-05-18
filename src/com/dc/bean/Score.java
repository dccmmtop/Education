package com.dc.bean;

public class Score
{
	private int Id;
	private String studentAccount;
	private String courseId;
	private float chengji;
	

	public Score()
	{
		// TODO 自动生成的构造函数存根
	}


	public int getId()
	{
		return Id;
	}


	public void setId(int id)
	{
		Id = id;
	}


	public String getStudentAccount()
	{
		return studentAccount;
	}


	public void setStudentAccount(String studentAccount)
	{
		this.studentAccount = studentAccount;
	}


	public String getCourseId()
	{
		return courseId;
	}


	public void setCourseId(String courseId)
	{
		this.courseId = courseId;
	}


	public float getChengji()
	{
		return chengji;
	}


	public void setChengji(float chengji)
	{
		this.chengji = chengji;
	}


	public Score(int id, String studentAccount, String courseId, float chengji)
	{
		super();
		Id = id;
		this.studentAccount = studentAccount;
		this.courseId = courseId;
		this.chengji = chengji;
	}


	@Override
	public String toString()
	{
		return "Score [Id=" + Id + ", studentAccount=" + studentAccount + ", courseId=" + courseId
				+ ", chengji=" + chengji + "]";
	}

}
