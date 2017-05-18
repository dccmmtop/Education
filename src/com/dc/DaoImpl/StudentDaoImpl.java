package com.dc.DaoImpl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.dc.bean.Student;
import com.dc.dao.StudentDao;
import com.dc.utils.JDBCUtils;

public class StudentDaoImpl implements StudentDao
{

	public StudentDaoImpl()
	{

	}

	@Override
	public Student findStudentById(String studentAccount)
	{
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Student getAllStduent(String studentAccount)
	{
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int getAllStduentCount()
	{
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public void add(String studentAccount, String studentPassword, String sex, String name)
	{
		Connection connection = JDBCUtils.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		String sql = "insert into student(student_account,student_name,student_sex,student_password) values(?,?,?,?)";
		Object params[] =new Object[]{ studentAccount, name,  sex, studentPassword };
		 
		try
		{
			queryRunner.update(connection,sql, params);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}
