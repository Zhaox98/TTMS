package com.xy.today.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xy.today.util.PlayInformation;

/**
 * 数据库   对  play表的一些  基本的操作
 * @author lwp940118
 *
 */
public class Play {

	/**
	 * list为play的获取的信息，sql查询后获取的list
	 */
	private List<PlayInformation> play = new ArrayList<PlayInformation>();

	/**
	 * 数据库定义
	 */
	private MovieConnection connection = null;


	/**
	 * 通过id  从   数据库中获取并且保存
	 * 获取得到list数组  然后进行包
	 * 读取多个 员工
	 * @param no
	 * @return
	 */
	public List<PlayInformation> prinfPlays() {
		connection = new MovieConnection(); // 连接数据库
		//数据库查询语句
		String sql = "SELECT * FROM play";
		if (connection.findTable(sql) != null) {
			System.out.println("play表读取成功");
			getplay((connection.findTable(sql)));
		} else {
			System.out.println("play表中没有数据");
		}
		connection.close();
		return play;
	}

	/**
	 * 通过id  从   数据库中获取并且保存
	 * 获取得到list数组  然后进行包
	 * 读取单个 员工
	 * @param no
	 * @return
	 */
	public List<PlayInformation> prinfPlay(String paly_id) {
		connection = new MovieConnection(); // 连接数据库
		//数据库查询语句
		String sql = "SELECT * FROM play WHERE play_id = '"+paly_id+"'";
		if (connection.findTable(sql) != null) {
			System.out.println("paly表读取成功");
			getplay((connection.findTable(sql)));
		} else {
			System.out.println("play表中没有数据");
		}
		connection.close();
		return play;
	}

	/**
	 * 获取paly表的信息 并且保存在list列表当中
	 *
	 *
	 *
	 * @param resultSet
	 * @return
	 */
	public void getplay(ResultSet resultSet) {

		try {
			play = new ArrayList<PlayInformation>();
			PlayInformation playInformation;
			while (resultSet.next()) {
				playInformation = new PlayInformation();
				//剧目id
				playInformation.setPlay_id((resultSet.getString(1)));
				//类型id
				playInformation.setPlay_type_id(resultSet.getString(2));
				//语言
				playInformation.setPlay_lang_id(resultSet.getString(3));
				//paly名称
				playInformation.setPlay_name(resultSet.getString(4));
				//介绍
				playInformation.setPlay_introduction(resultSet.getString(5));
				//图片
				playInformation.setPlay_image(resultSet.getString(6));
				//时长
				playInformation.setPlay_length(resultSet.getString(7));
				//票价
				playInformation.setPlay_ticket_price(resultSet.getString(8));
				//状态
				playInformation.setPlay_status(resultSet.getString(9));

				play.add(playInformation);
			}// 显示数据
			resultSet.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("play表信息数据查询出错");
		}
	}
	/**
	 * 添加  剧目的一些信息
	 * @param leixing
	 * @param yuyan
	 * @param name
	 * @param infro
	 * @param image
	 * @param shichang
	 * @param piaojia
	 * @param zhuangtai
	 * @return
	 */

	public boolean playAdd(String leixing,String yuyan,String name,String infro
			,String image,String shichang,String piaojia,String zhuangtai){

		connection = new MovieConnection(); // 连接数据库
		String sql = "insert into play(play_type_id,play_lang_id,play_name," +
				"play_introduction,play_image,play_length,play_ticket_price," +
				"play_status) values('"+leixing+"','"+yuyan+"','"+name+"','"
				+infro+"','"+image+"','"+shichang+"','"+piaojia+"','"+
				zhuangtai+"')";
		if (connection.insertTable(sql)) {
			System.out.println("员工信息注册成功");
			connection.close();
			return true;
		} else {
			System.out.println("员工信息注册失败");
		}
		connection.close();
		return false;
	}

	/**
	 * 根据工号删除剧目的信息  列表
	 * @param id
	 * @return
	 */
	public boolean DeletePlay(String id){
		connection = new MovieConnection(); // 连接数据库
		String sql = "DELETE FROM play WHERE play_id = '"+id+"'";
		if (connection.deleteTable(sql)) {
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}

	/**
	 * play  的修改  操作
	 * @param leixing
	 * @param yuyan
	 * @param name
	 * @param infro
	 * @param image
	 * @param shichang
	 * @param piaojia
	 * @param zhuangtai
	 * @param id
	 * @return
	 */
	public boolean playXiuGai(String leixing,String yuyan,String name,String infro
			,String image,String shichang,String piaojia,String zhuangtai,String id){
		connection = new MovieConnection(); // 连接数据库
		//数据库的操作语句
		String sql = "UPDATE play SET play_type_id = '"+leixing+
				"',play_lang_id = '"+yuyan+"',play_name = '"+name+
				"',play_introduction = '"+infro+"',play_image = '"+image+
				"',play_length = '"+shichang+"',play_ticket_price = '"+piaojia+
				"',play_status = '"+zhuangtai+"'"
				+" WHERE play_id = "+id;
		if (connection.updateTable(sql)) {
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}

}
