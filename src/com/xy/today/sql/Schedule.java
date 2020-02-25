package com.xy.today.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xy.today.util.PlayInformation;
import com.xy.today.util.ScheduleInformation;

/**
 * 从数据库中读取   计划  的信息
 * @author lwp940118
 *
 */
public class Schedule {

	/**
	 * list为Schedule的获取的信息，sql查询后获取的list
	 */
	private List<ScheduleInformation> schedule = new ArrayList<ScheduleInformation>();

	/**
	 * 数据库定义
	 */
	private MovieConnection connection = null;

	/**
	 * 演出计划添加  到数据库
	 * @param studio_id
	 * @param play_id
	 * @param sched_time
	 * @param sched_ticket_price
	 * @return
	 */
	public boolean scheduleAdd(String studio_id,String play_id,String sched_time
			,String sched_ticket_price,String time_id){
		String string = "";
		connection = new MovieConnection(); // 连接数据库
		String sql = "insert into schedule(studio_id,play_id,sched_time," +
				"sched_ticket_price,time_id) values('"+studio_id+"','"+play_id+"','"
				+sched_time+"','"+sched_ticket_price+"','"+time_id+"')";
		//System.out.println(sql);
		if (connection.insertTable(sql)) {

			connection.close();
			return true;
		} else {
			System.out.println("演出计划添加失败");
		}
		connection.close();
		return false;
	}

	/**
	 * 通过id  从   数据库中获取并且保存
	 * 获取得到list数组  然后进行包
	 * 读取多个 员工
	 * @param no
	 * @return
	 */
	public List<ScheduleInformation> prinfSchedules() {
		connection = new MovieConnection(); // 连接数据库
		//数据库查询语句
		String sql = "SELECT * FROM schedule";
		if (connection.findTable(sql) != null) {
			System.out.println("shedule表读取成功");
			getSchedule((connection.findTable(sql)));
		} else {
			System.out.println("schedule表中没有数据");
		}
		connection.close();
		return schedule;
	}

	/**
	 * 通过id  从   数据库中获取并且保存
	 * 获取得到list数组  然后进行包
	 * 读取单个 员工
	 * @param no
	 * @return
	 */
	public List<ScheduleInformation> prinfSchedule(String paly_id) {
		connection = new MovieConnection(); // 连接数据库
		//数据库查询语句
		System.out.println("say"+paly_id);
		String sql = "SELECT * FROM schedule WHERE sched_id = '"+paly_id+"'";
		if (connection.findTable(sql) != null) {
			System.out.println("schedule读取成功");
			getSchedule((connection.findTable(sql)));
		} else {
			System.out.println("schedule表中没有数据");
		}
		connection.close();
		return schedule;
	}

	/**
	 * 通过剧目的id 从   数据库中获取并且保存
	 * 获取得到list数组  然后进行包
	 * 读取单个 员工
	 * @param no
	 * @return
	 */
	public List<ScheduleInformation> prinfScheduleMovie(String paly_id) {
		connection = new MovieConnection(); // 连接数据库
		//数据库查询语句
		String sql = "SELECT * FROM schedule WHERE play_id = '"+paly_id+"'";
		if (connection.findTable(sql) != null) {
			System.out.println("schedule表读取成功");
			getSchedule((connection.findTable(sql)));
		} else {
			System.out.println("schedule表中没有数据");
		}
		connection.close();
		return schedule;
	}

	/**
	 * 获取Schedule表的信息 并且保存在list列表当中
	 *
	 *
	 *
	 * @param resultSet
	 * @return
	 */
	public void getSchedule(ResultSet resultSet) {

		try {
			schedule = new ArrayList<ScheduleInformation>();
			ScheduleInformation scheduleInformation;
			while (resultSet.next()) {
				scheduleInformation = new ScheduleInformation();
				//剧目id
				scheduleInformation.setSched_id(resultSet.getString(1));
				//类型id
				scheduleInformation.setStudio_id(resultSet.getString(2));
				//语言
				scheduleInformation.setPlay_id(resultSet.getString(3));
				//paly名称
				scheduleInformation.setSched_time(resultSet.getString(4));
				//介绍
				scheduleInformation.setSched_ticket_price(resultSet.getString(5));
				//图片
				scheduleInformation.setTime_id(resultSet.getString(6));

				schedule.add(scheduleInformation);
			}// 显示数据
			resultSet.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("演出计划从数据库中读取出错");
		}
	}



	/**
	 * 演出计划的删除
	 * @param id
	 * @return
	 */
	public boolean DeleteSchedule(String id){
		connection = new MovieConnection(); // 连接数据库
		String sql = "DELETE FROM schedule WHERE sched_id = '"+id+"'";
		if (connection.deleteTable(sql)) {
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}

	/**
	 * 演出计划的修改
	 * @param studio_id
	 * @param play_id
	 * @param sched_time
	 * @param sched_ticket_price
	 * @param time_id
	 * @return
	 */
	public boolean scheduleXiuGai(String studio_id,String play_id,String sched_time,
			String sched_ticket_price
			,String time_id,String sched_id){
		connection = new MovieConnection(); // 连接数据库
		//数据库的操作语句
		String sql = "UPDATE schedule SET studio_id = '"+studio_id+
				"',play_id = '"+play_id+"',sched_time = '"+sched_time+
				"',sched_ticket_price = '"+sched_ticket_price+"',time_id = '"
				+time_id+"'"
				+" WHERE sched_id = "+sched_id;
		if (connection.updateTable(sql)) {
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}


}
