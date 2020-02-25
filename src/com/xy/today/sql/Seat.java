package com.xy.today.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xy.today.util.SeatInformation;
import com.xy.today.util.StudioInformation;

/**
 * ���ݿ���  ��  seat���һЩ����
 * @author lwp940118
 *
 */
public class Seat {

	/**
	 * listΪseat�Ļ�ȡ����Ϣ��sql��ѯ���ȡ��list
	 */
	private List<SeatInformation> seat = new ArrayList<SeatInformation>();

	/**s
	 * ���ݿⶨ��
	 */

	private MovieConnection connection = null;

	/**
	 * ��λ ��  ���  ��Ϣ
	 * @param studio_id
	 * @param hang
	 * @param lie
	 * @param zhuangtai
	 * @return
	 */
	public boolean seatAdd(String studio_id,String hang,String lie,
			String zhuangtai){

		connection = new MovieConnection(); // �������ݿ�
		String sql = "insert into seat(studio_id,seat_row,seat_column," +
				"seat_status) values('"+studio_id+"','"+hang+"','"+lie+"','"
				+zhuangtai+"')";
		System.out.println(sql);
		if (connection.insertTable(sql)) {
			System.out.println("seat ��ӳɹ�");
			connection.close();
			return true;
		} else {
			System.out.println("seat ���ʧ��");
		}
		connection.close();
		return false;
	}

	/**
	 * ����idɾ����λ����Ϣ  �б�
	 * @param id
	 * @return
	 */
	public boolean DeleteSeat(String id){
		connection = new MovieConnection(); // �������ݿ�
		String sql = "DELETE FROM seat WHERE studio_id = '"+id+"'";
		if (connection.deleteTable(sql)) {
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}


	/**
	 * ͨ��id  ��   ���ݿ��л�ȡ���ұ���
	 * ��ȡ�õ�list����  Ȼ����а�
	 * ��ȡ���� ��λ
	 * @param no
	 * @return
	 */
	public List<SeatInformation> prinfSeats(String studio_id) {
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ��ѯ���
		String sql = "SELECT * FROM seat WHERE studio_id = '"+studio_id+"'";
		if (connection.findTable(sql) != null) {
			System.out.println("seat���ȡ�ɹ�");
			getSeat((connection.findTable(sql)));
		} else {
			System.out.println("seat����û������");
		}
		connection.close();
		return seat;
	}

	/**
	 * ������λ����  ��  �����ݳ�����id����Ʊ��id
	 * @param studio_id
	 * @param seat_row
	 * @param seat_column
	 * @return
	 */
	public String prinfPiaoSeat(String studio_id,
			String seat_row,String seat_column) {
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ��ѯ���
		String string = "";
		String sql = "SELECT seat_id FROM seat WHERE studio_id = '"+studio_id+"' and seat_row" +
				" = '"+seat_row+"' and seat_column = '"+seat_column+"'";
		if (connection.findTable(sql) != null) {
			//System.out.println("seat���ȡ�ɹ�");
			string = getseatID((connection.findTable(sql)));
			connection.close();
			return string;
		} else {
			System.out.println("seat����û������");
		}
		connection.close();
		return "";
	}
	/**
	 * ������λ��id
	 * @param resultSet
	 * @return
	 */
	public String getseatID(ResultSet resultSet) {
		String string = "";
		try {
			while (resultSet.next()) {

				string = resultSet.getString(1);

			}// ��ʾ����
			resultSet.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��λ��  ��Ϣ��ѯ����");
		}
		return string;
	}
	/**
	 * ����seat id����  ��λ��Ϣ
	 * @param seat_id
	 * @return
	 */
	public List<SeatInformation> prinfSeat(String seat_id) {
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ��ѯ���
		String sql = "SELECT * FROM seat WHERE seat_id = '"+seat_id+"'";
		if (connection.findTable(sql) != null) {
			System.out.println("seat���ȡ�ɹ�");
			getSeat((connection.findTable(sql)));
		} else {
			System.out.println("seat����û������");
		}
		connection.close();
		return seat;
	}

	/**
	 * ��ȡpaly�����Ϣ ���ұ�����list�б���
	 *
	 *
	 *
	 * @param resultSet
	 * @return
	 */
	public void getSeat(ResultSet resultSet) {

		try {
			seat = new ArrayList<SeatInformation>();
			SeatInformation seatInformation;
			while (resultSet.next()) {
				seatInformation = new SeatInformation();
				//��Ŀid
				seatInformation.setSeat_id((resultSet.getString(1)));
				//�ݳ���id
				seatInformation.setStudio_id((resultSet.getString(2)));
				//��λ  ��
				seatInformation.setSeat_row((resultSet.getString(3)));
				//��λ  ��
				seatInformation.setSeat_column((resultSet.getString(4)));
				//��λ״̬
				seatInformation.setSeat_status((resultSet.getString(5)));

				seat.add(seatInformation);
			}// ��ʾ����
			resultSet.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��λ��  ��Ϣ��ѯ����");
		}
	}

	/**
	 * ��λ�޸�  �� ������Ϣ
	 * @param studio_id
	 * @param seat_row
	 * @param seat_column
	 * @param seat_status
	 * @param seat_id
	 * @return
	 */
	public boolean seatXiuGai(String studio_id,String seat_row,
			String seat_column,String seat_status){
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ�Ĳ������
		String sql = "UPDATE seat SET seat_status = '"+seat_status+"'"+
				" WHERE studio_id= '"+studio_id+
				"' and seat_row = '"+seat_row+"' and seat_column = '"+
				seat_column+"'";
		if (connection.updateTable(sql)) {

			System.out.println("�޸ĳɹ�");
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}


	/**
	 * ��ȡpaly�����Ϣ ���ұ�����list�б���
	 *
	 * ������
	 *
	 * @param resultSet
	 * @return
	 */
	public String getSeatStatus(ResultSet resultSet) {

		try {

			while (resultSet.next()) {
				connection.close();
				return resultSet.getString(1);
			}// ��ʾ����
			resultSet.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��λ��  ��Ϣ��ѯ����");
		}
		return null;
	}
	/**
	 * ����  ��λ��״̬
	 * @param studio_id
	 * @param seat_row
	 * @param seat_column
	 * @return
	 */
	public String prinfSeatStatus(String studio_id,String seat_row,String seat_column) {
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ��ѯ���
		String sql = "SELECT seat_status FROM seat WHERE studio_id = '"+studio_id+"' and" +
				" seat_row = '"+seat_row+"' and seat_column = '"+seat_column+"'";
		if (connection.findTable(sql) != null) {
			System.out.println("seat���ȡ�ɹ�");
			connection.close();
			return getSeatStatus(((connection.findTable(sql))));
		} else {
			System.out.println("seat����û������");
		}
		connection.close();
		return "0";
	}

}
