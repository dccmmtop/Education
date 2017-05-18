package com.dc.dao;

import java.util.List;

public interface ScoreDao
{

	public void insert(String studentId,String courseId,float score);
	public List<Object[]>getXuankeInfo(String studentAccount);
	public void delete(String studentAccount);
	public List<Object[]>getScore(String studentAccount);
}
