package com.xy.today.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xy.today.util.PlayInformation;
import com.xy.today.util.TcketInformation;

/**
 * 数据库中 对票的操作 具体的实现方法
 *
 */
public class Ticket {
	/**
	 * 票的查询后的list
	 */
	private List<TcketInformation> tcketInformations = new ArrayList<TcketInformation>();

	/**
	 * 数据库定义
	 */
	private MovieConnection connection = null;

	/**
	 * 票的添加
	 * @param seat_id
	 * @param sched_id
	 * @param ticket_price
	 * @param ticket_status
	 * @return
	 */
	public boolean tcketAdd(String seat_id, String sched_id,
			String ticket_price, String ticket_status) {

		connection = new MovieConnection(); // 连接数据库
		String sql = "insert into ticket(seat_id,sched_id,ticket_price,ticket_status) "
				+ "values('"
				+ seat_id
				+ "','"
				+ sched_id
				+ "','"
				+ ticket_price + "','" + ticket_status + "')";
		if (connection.insertTable(sql)) {
			connection.close();
			return true;
		} else {
			System.out.println("失败");
		}
		connection.close();
		return false;
	}

	/**
	 * 根据   演出计划的id 删除票
	 * @param id
	 * @return
	 */
	public boolean deleteTcket(String id){
		connection = new MovieConnection(); // 连接数据库
		String sql = "DELETE FROM ticket WHERE sched_id = id";
		if (connection.deleteTable(sql)) {
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}

	/**
	 * 用剧目id查找电影票   将其以list的形式保存起来
	 * @param sched_id
	 * @return
	 */
	public List<TcketInformation> prinfPlay(String sched_id) {
		connection = new MovieConnection(); // 连接数据库
		//数据库查询语句
		String sql = "SELECT * FROM ticket WHERE sched_id = '"+sched_id+"'";
		if (connection.findTable(sql) != null) {
			System.out.println("影票查找成功");
			getTicket((connection.findTable(sql)));
		} else {
			System.out.println("影票查找失败");
		}
		connection.close();
		return tcketInformations;
	}

	/**
	 * 用剧目id查找电影票   将其以list的形式保存起来
	 * @param sched_id
	 * @return
	 */
	public List<TcketInformation> prinfmaipiao(String sched_id) {
		connection = new MovieConnection(); // 连接数据库
		//数据库查询语句
		String sql = "SELECT * FROM ticket WHERE sched_id = sched_id and " +
				"ticket_status = '1'";
		if (connection.findTable(sql) != null) {
			System.out.println("影票查找成功");
			getTicket((connection.findTable(sql)));
		} else {
			System.out.println("影票查找失败");
		}
		connection.close();
		return tcketInformations;
	}

	/**
	 * 获取票  放到list中
	 * @param resultSet
	 */
	public void getTicket(ResultSet resultSet) {

		try {
			tcketInformations = new ArrayList<TcketInformation>();
			TcketInformation tcketInformation;
			while (resultSet.next()) {
				tcketInformation = new TcketInformation();

				tcketInformation.setTicket_id((resultSet.getString(1)));

				tcketInformation.setSeat_id(resultSet.getString(2));

				tcketInformation.setSched_id(resultSet.getString(3));

				tcketInformation.setTicket_price(resultSet.getString(4));

				tcketInformation.setTicket_status(resultSet.getString(5));

				tcketInformations.add(tcketInformation);
			}// 显示数据
			resultSet.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据座位的id  和  演出计划的id  对票的状态进行修改
	 * @param ticket_status
	 * @param seat_id
	 * @param sched_id
	 * @return
	 */
	public boolean ticketXiuGai(String ticket_status,String seat_id,
			String sched_id){
		connection = new MovieConnection(); // 连接数据库
		//数据库的操作语句
		String sql = "UPDATE ticket SET ticket_status = '"+ticket_status
				+"' WHERE seat_id = '"+seat_id+"' and sched_id = '"+sched_id+"'";
		if (connection.updateTable(sql)) {
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}

	/**
	 * 退票操作
	 * @param ticket_id
	 * @return
	 */
	public boolean ticketTuipiao(String ticket_id){
		connection = new MovieConnection(); // 连接数据库
		//数据库的操作语句
		String sql = "UPDATE ticket SET ticket_status = '0'"
				+" WHERE ticket_id = '"+ticket_id+"'";
		if (connection.updateTable(sql)) {
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}
}
