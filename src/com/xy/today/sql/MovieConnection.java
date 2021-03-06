package com.xy.today.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MovieConnection {

	/*
	 * 需求：java连接mysql数据库进行数据连接,对mysql中的表的增删改操作
	 *
	 *
	 */

	public static final String url = "jdbc:mysql://localhost:3306/movie?t?useUnicode=true&characterEncoding=utf-8&useSSL=false"
			;
	public static final String name = "com.mysql.jdbc.Driver";
	//public static final String user = "root";
	//public static final String password = "123456";

	public static Connection connection = null; // 连接
	public PreparedStatement statement = null; // 执行

	// 数据库连接
	public MovieConnection() {
		try {
			Class.forName(name); // 指定连接类型
			connection = DriverManager.getConnection(url, "root", "123456"); // 获取数据库连接
			System.out.println("连接成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//System.out.println("数据库连接出错");
		}
	}

	public void close() {
		try {
			this.connection.close();
			this.statement.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("数据库关闭出错");
		}
	}

	//数据库查找

	public ResultSet findTable(String sql){

		ResultSet resultSet = null;

		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("查询数据库表时出错");
			e.printStackTrace();
		}

		return resultSet;
	}

	//数据库对表的插入
	public boolean insertTable(String sql) {

		try {
			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("数据库插入表元素时出错");
			e.printStackTrace();
		}

		return false;
	}

	//数据库对表的删除
	public boolean deleteTable(String sql){
		try {
			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("数据库删除表元素时出错");
			e.printStackTrace();
		}

		return false;
	}

	//数据库中对表的修改
	public boolean updateTable(String sql){
		try {

			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("数据库修改表元素时出错");
			e.printStackTrace();
		}

		return false;
	}

}
