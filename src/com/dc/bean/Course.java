package com.dc.bean;

public class Course
{
	private int courseId;
	private String courseName;
	private float courseScore;
	private String teacherAccount;
	private String classRoom;
	
	

	public Course()
	{
		// TODO 自动生成的构造函数存根
	}



	public int getCourseId()
	{
		return courseId;
	}



	public void setCourseId(int courseId)
	{
		this.courseId = courseId;
	}



	public String getCourseName()
	{
		return courseName;
	}



	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}



	public float getCourseScore()
	{
		return courseScore;
	}



	public void setCourseScore(float courseScore)
	{
		this.courseScore = courseScore;
	}



	public String getTeacherAccount()
	{
		return teacherAccount;
	}



	public void setTeacherAccount(String teacherAccount)
	{
		this.teacherAccount = teacherAccount;
	}



	public String getClassRoom()
	{
		return classRoom;
	}



	public void setClassRoom(String classRoom)
	{
		this.classRoom = classRoom;
	}



	public Course(int courseId, String courseName, float courseScore, String teacherAccount,
			String classRoom)
	{
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseScore = courseScore;
		this.teacherAccount = teacherAccount;
		this.classRoom = classRoom;
	}

	@Override
	public String toString()
	{
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseScore="
				+ courseScore + ", teacherAccount=" + teacherAccount + ", classRoom=" + classRoom
				+ "]";
	}

}
