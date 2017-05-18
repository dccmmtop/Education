package com.dc.DaoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import com.dc.dao.CourseDao;
import com.dc.utils.JDBCUtils;

public class CourseDaoImpl implements CourseDao {

	public CourseDaoImpl() {

	}

	@Override
	public List<Object[]> getAllCourse() {
		Connection connection = JDBCUtils.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		String sql = "select course_id,course_name,course_score,teacher.teacher_account,teacher_name from course,teacher where course.teacher_account=teacher.teacher_account;";
		try {
			List<Object[]> list = queryRunner.query(connection, sql,
					new ArrayListHandler());
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	 

}
