package com.dc.dao;

public interface LoginDao
{
	public int accountNum(String account);
	public String getPassword(String account);
	public void updataPassword(String account,String newPassword);
	 
}
