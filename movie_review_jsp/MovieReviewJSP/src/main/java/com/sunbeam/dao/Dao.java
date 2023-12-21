package com.sunbeam.dao;

import java.sql.Connection;


public class Dao implements AutoCloseable {
	protected Connection con;
	public Dao() {
		try {
			con = com.sunbeam.utils.DbUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void close() throws Exception {
		try {
		if(con!=null)
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
