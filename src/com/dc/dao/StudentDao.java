package com.dc.dao;

import com.dc.bean.Student;

public interface StudentDao
{
	public Student findStudentById(String studentAccount);
	public Student getAllStduent(String studentAccount);
	public int getAllStduentCount();
	public void add(String studentAccount,String stduentPassword,String sex,String name);
}
