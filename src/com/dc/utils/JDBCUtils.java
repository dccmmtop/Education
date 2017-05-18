package com.dc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils
{
	private static String className="com.mysql.jdbc.Driver";
	//private static String url="jdbc:mysql://dengchao/jiaowu?useUnicode=true&characterEncoding=utf-8";
	private static String url="jdbc:mysql://127.0.0.1/jiaowu?useUnicode=true&characterEncoding=utf-8";
	private static String name="root";
	private static String password="123456";
	public static Connection getConnection()  
	{
		Connection connection=null;
		try
		{
			Class.forName(className);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			connection=DriverManager.getConnection(url,name,password);
		} catch (SQLException e)
		{ 
			e.printStackTrace();
		}
		return connection;
	}
	
}
