package com.xy.today.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xy.today.util.EmployeeInformation;

import twaver.TUIManager;
import twaver.base.A.E.b;



/**
 * ���󣺶�Employees�������ɾ�Ĳ�;
 * ���� ��Ա�����һЩ����
 *
 *
 */

public class Employee {
	/**
	 * listΪEmployee�Ļ�ȡ����Ϣ��sql��ѯ���ȡ��list
	 */
	private List<EmployeeInformation> employee = null;

	/**
	 * ���ݿⶨ��
	 */
	private MovieConnection connection = null;


	/**
	 * ͨ��id  ��   ���ݿ��л�ȡ���ұ���
	 * ��ȡ�õ�list����  Ȼ����а�
	 * ��ȡ���� Ա��
	 * @param no
	 * @return
	 */
	public List<EmployeeInformation> prinfEmployee(String no) {
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ��ѯ���
		String sql_find_emp = "SELECT * FROM employee WHERE emp_no = '"+no+"'";
		if (connection.findTable(sql_find_emp) != null) {
			System.out.println("Employee���ȡ�ɹ�");
			getEmployee(connection.findTable(sql_find_emp));
		} else {
			System.out.println("employee����û������");
		}
		connection.close();
		return employee;
	}

	/**
	 * ͨ��id  ��   ���ݿ��л�ȡ���ұ���
	 * ��ȡ�õ�list����  Ȼ����а�
	 * ��ȡ��� Ա��
	 * @param no
	 * @return
	 */
	public List<EmployeeInformation> prinfEmployees() {
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ��ѯ���
		String sql_find_emp = "SELECT * FROM employee";
		if (connection.findTable(sql_find_emp) != null) {
			System.out.println("Employee���ȡ�ɹ�");
			getEmployee(connection.findTable(sql_find_emp));
		} else {
			System.out.println("employee����û������");
		}
		connection.close();
		return employee;
	}
	/**
	 * ��ȡEmployee�����Ϣ ���ұ�����list�б���
	 *
	 * ������
	 *
	 * @param resultSet
	 * @return
	 */
	public void getEmployee(ResultSet resultSet) {

		try {
			employee = new ArrayList<EmployeeInformation>();
			EmployeeInformation employeeInformation;
			while (resultSet.next()) {
				employeeInformation = new EmployeeInformation();
				//����
				employeeInformation.setEmp_No(resultSet.getString(1));
				//����
				employeeInformation.setEmp_Name(resultSet.getString(2));
				//����
				employeeInformation.setEmp_Password(resultSet.getString(3));
				//ְλ
				employeeInformation.setEmp_Position(resultSet.getString(4));
				//�绰
				employeeInformation.setEmp_Tel_Num(resultSet.getString(5));
				//��ַ
				employeeInformation.setEmp_Addr(resultSet.getString(6));
				//����
				employeeInformation.setEmp_Email(resultSet.getString(7));
				//��ְʱ��
				employeeInformation.setEmp_Induction_Time(resultSet.getString(8));
				//��н
				employeeInformation.setEmp_Month_Money(resultSet.getString(9));
				//���칤��
				employeeInformation.setEmp_Sum_Money(resultSet.getString(10));
				//����
				employeeInformation.setEmp_Holiday(resultSet.getString(11));
				//����
				employeeInformation.setEmp_Age(resultSet.getString(12));
				//�Ա�
				employeeInformation.setEmp_Sex(resultSet.getString(13));
				employee.add(employeeInformation);
			}// ��ʾ����
			resultSet.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ա������Ϣ���ݲ�ѯ����");
		}
	}
	/**
	 * ������Ϣ �޸�
	 * @param string_xingming
	 * @param string_nianling
	 * @param string_dianhua
	 * @param string_youxiang
	 * @param string_dizhi
	 * @param string_sex
	 * @param string_zhiwei
	 * @return
	 */
	public boolean geRenXinXiXiuGai(String string_xingming,String string_nianling,
			String string_dianhua,String string_youxiang,String string_dizhi,
			String string_sex,String string_zhiwei,String id){
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ�Ĳ������
		String sql = "UPDATE employee SET emp_name = '"+string_xingming+
				"',emp_tel_num = '"+string_dianhua+"',emp_addr = '"+string_dizhi+
				"',emp_email = '"+string_youxiang+"',emp_position = '"+string_zhiwei+
				"',emp_age = '"+string_nianling+"',emp_sex = '"+string_sex+"'"
				+" WHERE emp_id = "+id;
		if (connection.updateTable(sql)) {
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}

	public boolean yuanGongXinXiXiuGai(String string_xingming,String string_nianling,
			String string_ruzhishijian,String string_qingjia,String string_yuexin,
			String string_sex,String string_zhiwei,String mima,String id){
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ�Ĳ������
		String sql = "UPDATE employee SET emp_name = '"+string_xingming+
				"',emp_induction_time = '"+string_ruzhishijian+"',emp_month_money = '"+string_yuexin+
				"',emp_holiday = '"+string_qingjia+"',emp_position = '"+string_zhiwei+
				"',emp_age = '"+string_nianling+"',emp_sex = '"+string_sex+"',emp_password = '"+mima+"'\n"
				+" WHERE emp_no = "+id;
		if (connection.updateTable(sql)) {
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}
	/**
	 * Ա�������޸� �����޸�
	 * @param string_pass
	 * @param id
	 * @return
	 */
	public boolean miMaXiuGai(String string_pass,String id){
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ�Ĳ������
		String sql = "UPDATE employee SET emp_password = '"+string_pass+"'"
				+" WHERE emp_no = "+id;
		if (connection.updateTable(sql)) {
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}

	/**
	 * ���ݿ���Ա���ĵ�¼ �ɹ�����flose
	 *
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean loginin(String name, String password) {
		connection = new MovieConnection(); // �������ݿ�
		String sql = "SELECT emp_password\n" + "FROM employee\n" + "WHERE emp_no = "
				+ name;
		System.out.println("name--->" + name);
		if (connection.findTable(sql) != null) {
			//System.out.println("Employee���ȡ�ɹ�");
			if (mimafanhui(password, connection.findTable(sql))) {
				connection.close();
				return true;
			}

		} else {
			System.out.println("employee����û������");
		}

		connection.close();
		return false;
	}
	/**
	 * �ж������Ƿ���ȷ
	 * @param string
	 * @param resultSet
	 * @return
	 */
	private boolean mimafanhui(String string,ResultSet resultSet){
		try {
			String emp_password = "";
			while (resultSet.next()) {
				emp_password = resultSet.getString(1);
				System.out.println(emp_password);
			}// ��ʾ����
			resultSet.close();// �ر�����
			if (emp_password.equals(string)) {
				connection.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ա����¼���س���");
		}
		return false;
	}

	/**
	 * ����today��Ժ�Ĺ�����Ա��ע�ắ��
	 * ������
	 * @param name
	 * @param password
	 * @param zhiwei
	 * @return
	 */
	public String employeeRegistered(String name,String password,String zhiwei){
		String string_zhanghao = "";

		connection = new MovieConnection(); // �������ݿ�
		String sql = "insert into employee(emp_name,emp_password,emp_position) values('"+name
				+"','"+password+"','"+zhiwei+"')";
		if (connection.insertTable(sql)) {
			System.out.println("Ա����Ϣע��ɹ�");
			String sql_id = "SELECT emp_no\n" + "FROM employee";
			string_zhanghao = zhuCeFanHuiId(connection.findTable(sql_id));

		} else {
			System.out.println("Ա����Ϣע��ʧ��");
		}
		connection.close();
		return string_zhanghao;
	}

	/**
	 * ���  ������Ա
	 * @param name
	 * @param password
	 * @param zhiwei
	 * @param xingbie
	 * @param nianling
	 * @param yuexin
	 * @param qingjiatianshu
	 * @param ruzhishijian
	 * @return
	 */
	public String employeeAdd(String name,String password,String zhiwei,String xingbie
			,String nianling,String yuexin,String qingjiatianshu,String ruzhishijian ){
		String string_zhanghao = "";

		connection = new MovieConnection(); // �������ݿ�
		String sql = "insert into employee(emp_name,emp_password,emp_position" +
				",emp_sex,emp_age,emp_month_money,emp_holiday,emp_induction_time) values('"+name
				+"','"+password+"','"+zhiwei+"','"+xingbie+"','"+nianling
				+"','"+yuexin+"','"+qingjiatianshu+"','"+ruzhishijian+"')";
		if (connection.insertTable(sql)) {
			System.out.println("Ա�����ע��ɹ�");
			String sql_id = "SELECT emp_no\n" + "FROM employee";
			string_zhanghao = zhuCeFanHuiId(connection.findTable(sql_id));

		} else {
			System.out.println("Ա�����ע��ʧ��");
		}
		connection.close();
		return string_zhanghao;
	}

	/**
	 * Ա����Ϣ  ����  ְλ
	 * @param id
	 * @return
	 */
	public String employeeZhiWei(String id){
		String zhiwei = "";
		connection = new MovieConnection(); // �������ݿ�
		String sql = "SELECT emp_position\n" + "FROM employee\n" + "WHERE emp_no = "
				+ id;

		if (connection.findTable(sql) != null) {
			//System.out.println("Employee���ȡ�ɹ�");
			zhiwei = zhuCeFanHuiId(connection.findTable(sql));

		} else {
			System.out.println("ְλ����ʧ��");
		}
		connection.close();
		return zhiwei;
	}
	/**
	 * ע��  ���ݲ���� ���֮��  ����id  �������˺�
	 * ��¼ʱ ���øú���  ���� ְλ������������һ����İ���
	 * @param resultSet
	 * @return
	 */
	private String zhuCeFanHuiId(ResultSet resultSet){
		String string = "";
		System.out.println(resultSet);
		try {
			while (resultSet.next()) {
				string = resultSet.getString(1);
				System.out.println(string);
			}// ��ʾ����
			resultSet.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ע����� ����IDʱ����");
		}
		return string;
	}
	/**
	 * ���ݹ���ɾ��  Ա������Ϣ  �б�
	 * @param id
	 * @return
	 */
	public boolean DeleteEmployee(String id){
		connection = new MovieConnection(); // �������ݿ�
		String sql = "DELETE FROM employee WHERE emp_no = '"+id+"'";
		if (connection.deleteTable(sql)) {
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}


}
