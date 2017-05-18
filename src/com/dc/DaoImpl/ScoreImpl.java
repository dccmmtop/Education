package com.dc.DaoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import com.dc.dao.ScoreDao;
import com.dc.utils.JDBCUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class ScoreImpl implements ScoreDao
{

	public ScoreImpl()
	{
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void insert(String studentId, String courseId, float score)
	{
		 Connection connection=JDBCUtils.getConnection();
		 QueryRunner queryRunner=new QueryRunner();
		 String sql="insert into score(student_account,course_id,chengji)values(?,?,?)";
		 Object params[]= {studentId,courseId,score};
		 try
		{
			queryRunner.update(connection,sql,params);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(String studentAccount) {
		Connection connection=JDBCUtils.getConnection();
		 QueryRunner queryRunner=new QueryRunner();
		 String sql="delete from score where student_account="+studentAccount;
		 try {
			queryRunner.update(connection,sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Object[]> getXuankeInfo(String studentAccount)
	{
		 Connection connection=JDBCUtils.getConnection();
		 QueryRunner queryRunner=new QueryRunner();
		 String sql="SELECT score.course_id,course_name,course_score,teacher.teacher_account,teacher_name from score,course,teacher,student where score.student_account="+ studentAccount+" and course.teacher_account=teacher.teacher_account and  course.course_id=score.course_id and student.student_account=score.student_account";
		 try
		{
			List<Object[]>list=queryRunner.query(connection, sql, new ArrayListHandler());
			return list;
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Object[]> getScore(String studentAccount)
	{
		Connection connection=JDBCUtils.getConnection();
		QueryRunner queryRunner=new QueryRunner();
		String sql="select course.course_id,course_name,score.chengji,teacher.teacher_account,teacher_name from score,student,course,teacher where score.student_account='"+studentAccount+"' and score.course_id=course.course_id and student.student_account=score.student_account and teacher.teacher_account=course.teacher_account;";
		try
		{
			List<Object[]>list=queryRunner.query(connection, sql,new ArrayListHandler());
			return list;
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return null;
	}

}
