package com.xy.today.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MovieConnection {

	/*
	 * ����java����mysql���ݿ������������,��mysql�еı����ɾ�Ĳ���
	 *
	 *
	 */

	public static final String url = "jdbc:mysql://localhost:3306/movie?t?useUnicode=true&characterEncoding=utf-8&useSSL=false"
			;
	public static final String name = "com.mysql.jdbc.Driver";
	//public static final String user = "root";
	//public static final String password = "123456";

	public static Connection connection = null; // ����
	public PreparedStatement statement = null; // ִ��

	// ���ݿ�����
	public MovieConnection() {
		try {
			Class.forName(name); // ָ����������
			connection = DriverManager.getConnection(url, "root", "123456"); // ��ȡ���ݿ�����
			System.out.println("���ӳɹ�");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//System.out.println("���ݿ����ӳ���");
		}
	}

	public void close() {
		try {
			this.connection.close();
			this.statement.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("���ݿ�رճ���");
		}
	}

	//���ݿ����

	public ResultSet findTable(String sql){

		ResultSet resultSet = null;

		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("��ѯ���ݿ��ʱ����");
			e.printStackTrace();
		}

		return resultSet;
	}

	//���ݿ�Ա�Ĳ���
	public boolean insertTable(String sql) {

		try {
			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���ݿ�����Ԫ��ʱ����");
			e.printStackTrace();
		}

		return false;
	}

	//���ݿ�Ա��ɾ��
	public boolean deleteTable(String sql){
		try {
			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���ݿ�ɾ����Ԫ��ʱ����");
			e.printStackTrace();
		}

		return false;
	}

	//���ݿ��жԱ���޸�
	public boolean updateTable(String sql){
		try {

			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���ݿ��޸ı�Ԫ��ʱ����");
			e.printStackTrace();
		}

		return false;
	}

}
