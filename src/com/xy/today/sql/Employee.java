package com.xy.today.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xy.today.util.EmployeeInformation;

import twaver.TUIManager;
import twaver.base.A.E.b;



/**
 * 需求：对Employees表进行增删改差;
 * 及其 对员工表的一些操作
 *
 *
 */

public class Employee {
	/**
	 * list为Employee的获取的信息，sql查询后获取的list
	 */
	private List<EmployeeInformation> employee = null;

	/**
	 * 数据库定义
	 */
	private MovieConnection connection = null;


	/**
	 * 通过id  从   数据库中获取并且保存
	 * 获取得到list数组  然后进行包
	 * 读取单个 员工
	 * @param no
	 * @return
	 */
	public List<EmployeeInformation> prinfEmployee(String no) {
		connection = new MovieConnection(); // 连接数据库
		//数据库查询语句
		String sql_find_emp = "SELECT * FROM employee WHERE emp_no = '"+no+"'";
		if (connection.findTable(sql_find_emp) != null) {
			System.out.println("Employee表读取成功");
			getEmployee(connection.findTable(sql_find_emp));
		} else {
			System.out.println("employee表中没有数据");
		}
		connection.close();
		return employee;
	}

	/**
	 * 通过id  从   数据库中获取并且保存
	 * 获取得到list数组  然后进行包
	 * 读取多个 员工
	 * @param no
	 * @return
	 */
	public List<EmployeeInformation> prinfEmployees() {
		connection = new MovieConnection(); // 连接数据库
		//数据库查询语句
		String sql_find_emp = "SELECT * FROM employee";
		if (connection.findTable(sql_find_emp) != null) {
			System.out.println("Employee表读取成功");
			getEmployee(connection.findTable(sql_find_emp));
		} else {
			System.out.println("employee表中没有数据");
		}
		connection.close();
		return employee;
	}
	/**
	 * 获取Employee表的信息 并且保存在list列表当中
	 *
	 * 李文朋
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
				//工号
				employeeInformation.setEmp_No(resultSet.getString(1));
				//姓名
				employeeInformation.setEmp_Name(resultSet.getString(2));
				//密码
				employeeInformation.setEmp_Password(resultSet.getString(3));
				//职位
				employeeInformation.setEmp_Position(resultSet.getString(4));
				//电话
				employeeInformation.setEmp_Tel_Num(resultSet.getString(5));
				//地址
				employeeInformation.setEmp_Addr(resultSet.getString(6));
				//邮箱
				employeeInformation.setEmp_Email(resultSet.getString(7));
				//入职时间
				employeeInformation.setEmp_Induction_Time(resultSet.getString(8));
				//月薪
				employeeInformation.setEmp_Month_Money(resultSet.getString(9));
				//已领工资
				employeeInformation.setEmp_Sum_Money(resultSet.getString(10));
				//假期
				employeeInformation.setEmp_Holiday(resultSet.getString(11));
				//年龄
				employeeInformation.setEmp_Age(resultSet.getString(12));
				//性别
				employeeInformation.setEmp_Sex(resultSet.getString(13));
				employee.add(employeeInformation);
			}// 显示数据
			resultSet.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("员工表信息数据查询出错");
		}
	}
	/**
	 * 个人信息 修改
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
		connection = new MovieConnection(); // 连接数据库
		//数据库的操作语句
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
		connection = new MovieConnection(); // 连接数据库
		//数据库的操作语句
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
	 * 员工的密修改 密码修改
	 * @param string_pass
	 * @param id
	 * @return
	 */
	public boolean miMaXiuGai(String string_pass,String id){
		connection = new MovieConnection(); // 连接数据库
		//数据库的操作语句
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
	 * 数据库中员工的登录 成功返回flose
	 *
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean loginin(String name, String password) {
		connection = new MovieConnection(); // 连接数据库
		String sql = "SELECT emp_password\n" + "FROM employee\n" + "WHERE emp_no = "
				+ name;
		System.out.println("name--->" + name);
		if (connection.findTable(sql) != null) {
			//System.out.println("Employee表读取成功");
			if (mimafanhui(password, connection.findTable(sql))) {
				connection.close();
				return true;
			}

		} else {
			System.out.println("employee表中没有数据");
		}

		connection.close();
		return false;
	}
	/**
	 * 判断密码是否正确
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
			}// 显示数据
			resultSet.close();// 关闭连接
			if (emp_password.equals(string)) {
				connection.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("员工登录返回出错");
		}
		return false;
	}

	/**
	 * 需求：today剧院的工作人员的注册函数
	 * 李文朋
	 * @param name
	 * @param password
	 * @param zhiwei
	 * @return
	 */
	public String employeeRegistered(String name,String password,String zhiwei){
		String string_zhanghao = "";

		connection = new MovieConnection(); // 连接数据库
		String sql = "insert into employee(emp_name,emp_password,emp_position) values('"+name
				+"','"+password+"','"+zhiwei+"')";
		if (connection.insertTable(sql)) {
			System.out.println("员工信息注册成功");
			String sql_id = "SELECT emp_no\n" + "FROM employee";
			string_zhanghao = zhuCeFanHuiId(connection.findTable(sql_id));

		} else {
			System.out.println("员工信息注册失败");
		}
		connection.close();
		return string_zhanghao;
	}

	/**
	 * 添加  工作人员
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

		connection = new MovieConnection(); // 连接数据库
		String sql = "insert into employee(emp_name,emp_password,emp_position" +
				",emp_sex,emp_age,emp_month_money,emp_holiday,emp_induction_time) values('"+name
				+"','"+password+"','"+zhiwei+"','"+xingbie+"','"+nianling
				+"','"+yuexin+"','"+qingjiatianshu+"','"+ruzhishijian+"')";
		if (connection.insertTable(sql)) {
			System.out.println("员工添加注册成功");
			String sql_id = "SELECT emp_no\n" + "FROM employee";
			string_zhanghao = zhuCeFanHuiId(connection.findTable(sql_id));

		} else {
			System.out.println("员工添加注册失败");
		}
		connection.close();
		return string_zhanghao;
	}

	/**
	 * 员工信息  返回  职位
	 * @param id
	 * @return
	 */
	public String employeeZhiWei(String id){
		String zhiwei = "";
		connection = new MovieConnection(); // 连接数据库
		String sql = "SELECT emp_position\n" + "FROM employee\n" + "WHERE emp_no = "
				+ id;

		if (connection.findTable(sql) != null) {
			//System.out.println("Employee表读取成功");
			zhiwei = zhuCeFanHuiId(connection.findTable(sql));

		} else {
			System.out.println("职位返回失败");
		}
		connection.close();
		return zhiwei;
	}
	/**
	 * 注册  数据插入表 完成之后  返回id  即返回账号
	 * 登录时 利用该函数  返回 职位，，，进行下一界面的安排
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
			}// 显示数据
			resultSet.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("注册完成 返回ID时出错");
		}
		return string;
	}
	/**
	 * 根据工号删除  员工的信息  列表
	 * @param id
	 * @return
	 */
	public boolean DeleteEmployee(String id){
		connection = new MovieConnection(); // 连接数据库
		String sql = "DELETE FROM employee WHERE emp_no = '"+id+"'";
		if (connection.deleteTable(sql)) {
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}


}
