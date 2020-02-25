package com.xy.today.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xy.today.util.Schedule_TimeInformation;

/**
 * �����ݿ��ж�ȡ   time  ��  ʱ�� ����
 * @author lwp940118
 *
 */
public class Schedule_Time {


	/**
	 * �����ݿ��л�ȡ   timelist 
	 */
	private List<Schedule_TimeInformation> time = new ArrayList<Schedule_TimeInformation>();

	/**s
	 * ���ݿⶨ��
	 */
	
	private MovieConnection connection = null;
	
	/**
	 * ����id  ��ȡ  time �б�
	 */
	
	public List<Schedule_TimeInformation> prinfTimes() {
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ��ѯ���
		String sql = "SELECT * FROM schedule_time";
		if (connection.findTable(sql) != null) {
			System.out.println("time���ȡ�ɹ�");
			getTime((connection.findTable(sql)));
		} else {
			System.out.println("time����û������");
		}
		connection.close();
		return time;
	}
	
	/**
	 * ��ȡ  ʱ�� �� �б�
	 * @param resultSet
	 */
	public void getTime(ResultSet resultSet) {

		try {
			time = new ArrayList<Schedule_TimeInformation>();
			Schedule_TimeInformation seatInformation;
			while (resultSet.next()) {
				seatInformation = new Schedule_TimeInformation();
				//ʱ��id
				seatInformation.setTime_id((resultSet.getString(1)));
				//ʱ��
				seatInformation.setTime((resultSet.getString(2)));
				
				time.add(seatInformation);
			}// ��ʾ����
			resultSet.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ʱ���  ��Ϣ��ѯ����");
		}
	}
	
}
