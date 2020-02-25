package com.xy.today.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xy.today.util.PlayInformation;
import com.xy.today.util.ScheduleInformation;

/**
 * �����ݿ��ж�ȡ   �ƻ�  ����Ϣ
 * @author lwp940118
 *
 */
public class Schedule {

	/**
	 * listΪSchedule�Ļ�ȡ����Ϣ��sql��ѯ���ȡ��list
	 */
	private List<ScheduleInformation> schedule = new ArrayList<ScheduleInformation>();

	/**
	 * ���ݿⶨ��
	 */
	private MovieConnection connection = null;

	/**
	 * �ݳ��ƻ����  �����ݿ�
	 * @param studio_id
	 * @param play_id
	 * @param sched_time
	 * @param sched_ticket_price
	 * @return
	 */
	public boolean scheduleAdd(String studio_id,String play_id,String sched_time
			,String sched_ticket_price,String time_id){
		String string = "";
		connection = new MovieConnection(); // �������ݿ�
		String sql = "insert into schedule(studio_id,play_id,sched_time," +
				"sched_ticket_price,time_id) values('"+studio_id+"','"+play_id+"','"
				+sched_time+"','"+sched_ticket_price+"','"+time_id+"')";
		//System.out.println(sql);
		if (connection.insertTable(sql)) {

			connection.close();
			return true;
		} else {
			System.out.println("�ݳ��ƻ����ʧ��");
		}
		connection.close();
		return false;
	}

	/**
	 * ͨ��id  ��   ���ݿ��л�ȡ���ұ���
	 * ��ȡ�õ�list����  Ȼ����а�
	 * ��ȡ��� Ա��
	 * @param no
	 * @return
	 */
	public List<ScheduleInformation> prinfSchedules() {
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ��ѯ���
		String sql = "SELECT * FROM schedule";
		if (connection.findTable(sql) != null) {
			System.out.println("shedule���ȡ�ɹ�");
			getSchedule((connection.findTable(sql)));
		} else {
			System.out.println("schedule����û������");
		}
		connection.close();
		return schedule;
	}

	/**
	 * ͨ��id  ��   ���ݿ��л�ȡ���ұ���
	 * ��ȡ�õ�list����  Ȼ����а�
	 * ��ȡ���� Ա��
	 * @param no
	 * @return
	 */
	public List<ScheduleInformation> prinfSchedule(String paly_id) {
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ��ѯ���
		System.out.println("say"+paly_id);
		String sql = "SELECT * FROM schedule WHERE sched_id = '"+paly_id+"'";
		if (connection.findTable(sql) != null) {
			System.out.println("schedule��ȡ�ɹ�");
			getSchedule((connection.findTable(sql)));
		} else {
			System.out.println("schedule����û������");
		}
		connection.close();
		return schedule;
	}

	/**
	 * ͨ����Ŀ��id ��   ���ݿ��л�ȡ���ұ���
	 * ��ȡ�õ�list����  Ȼ����а�
	 * ��ȡ���� Ա��
	 * @param no
	 * @return
	 */
	public List<ScheduleInformation> prinfScheduleMovie(String paly_id) {
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ��ѯ���
		String sql = "SELECT * FROM schedule WHERE play_id = '"+paly_id+"'";
		if (connection.findTable(sql) != null) {
			System.out.println("schedule���ȡ�ɹ�");
			getSchedule((connection.findTable(sql)));
		} else {
			System.out.println("schedule����û������");
		}
		connection.close();
		return schedule;
	}

	/**
	 * ��ȡSchedule�����Ϣ ���ұ�����list�б���
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
				//��Ŀid
				scheduleInformation.setSched_id(resultSet.getString(1));
				//����id
				scheduleInformation.setStudio_id(resultSet.getString(2));
				//����
				scheduleInformation.setPlay_id(resultSet.getString(3));
				//paly����
				scheduleInformation.setSched_time(resultSet.getString(4));
				//����
				scheduleInformation.setSched_ticket_price(resultSet.getString(5));
				//ͼƬ
				scheduleInformation.setTime_id(resultSet.getString(6));

				schedule.add(scheduleInformation);
			}// ��ʾ����
			resultSet.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�ݳ��ƻ������ݿ��ж�ȡ����");
		}
	}



	/**
	 * �ݳ��ƻ���ɾ��
	 * @param id
	 * @return
	 */
	public boolean DeleteSchedule(String id){
		connection = new MovieConnection(); // �������ݿ�
		String sql = "DELETE FROM schedule WHERE sched_id = '"+id+"'";
		if (connection.deleteTable(sql)) {
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}

	/**
	 * �ݳ��ƻ����޸�
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
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ�Ĳ������
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
