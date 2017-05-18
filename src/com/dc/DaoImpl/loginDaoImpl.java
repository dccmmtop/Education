package com.dc.DaoImpl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import sun.org.mozilla.javascript.internal.ObjArray;

import com.dc.dao.LoginDao;
import com.dc.utils.JDBCUtils;

public class loginDaoImpl implements LoginDao
{

	@Override
	public int accountNum(String account)
	{
		Connection connection = JDBCUtils.getConnection();
		String sql = "select count(*) from student where student_account=" + account;
		QueryRunner queryRunner = new QueryRunner();
		Object[] num = null;
		try
		{
			num = queryRunner.query(connection, sql, new ArrayHandler());
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return Integer.valueOf(String.valueOf(num[0]));
	}

	@Override
	public String getPassword(String account)
	{
		Connection connection = JDBCUtils.getConnection();
		String sql = "select student_password from student where student_account=" + account;
		QueryRunner queryRunner = new QueryRunner();
		Object[] password = null;
		try
		{
			password = queryRunner.query(connection, sql, new ArrayHandler());
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return (String) password[0];
	}

	@Override
	public void updataPassword(String account,String newPassword) {
		 Connection connection=JDBCUtils.getConnection();
		 QueryRunner queryRunner=new QueryRunner();
		 String sql="update student set student_password=?where student_account=?";
		 Object param[]=new Object[]{newPassword,account  };
		 try {
			queryRunner.update(connection, sql, param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	}

}
