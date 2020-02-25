package com.xy.today.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xy.today.util.PlayInformation;
import com.xy.today.util.TcketInformation;

/**
 * ���ݿ��� ��Ʊ�Ĳ��� �����ʵ�ַ���
 *
 */
public class Ticket {
	/**
	 * Ʊ�Ĳ�ѯ���list
	 */
	private List<TcketInformation> tcketInformations = new ArrayList<TcketInformation>();

	/**
	 * ���ݿⶨ��
	 */
	private MovieConnection connection = null;

	/**
	 * Ʊ�����
	 * @param seat_id
	 * @param sched_id
	 * @param ticket_price
	 * @param ticket_status
	 * @return
	 */
	public boolean tcketAdd(String seat_id, String sched_id,
			String ticket_price, String ticket_status) {

		connection = new MovieConnection(); // �������ݿ�
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
			System.out.println("ʧ��");
		}
		connection.close();
		return false;
	}

	/**
	 * ����   �ݳ��ƻ���id ɾ��Ʊ
	 * @param id
	 * @return
	 */
	public boolean deleteTcket(String id){
		connection = new MovieConnection(); // �������ݿ�
		String sql = "DELETE FROM ticket WHERE sched_id = id";
		if (connection.deleteTable(sql)) {
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}

	/**
	 * �þ�Ŀid���ҵ�ӰƱ   ������list����ʽ��������
	 * @param sched_id
	 * @return
	 */
	public List<TcketInformation> prinfPlay(String sched_id) {
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ��ѯ���
		String sql = "SELECT * FROM ticket WHERE sched_id = '"+sched_id+"'";
		if (connection.findTable(sql) != null) {
			System.out.println("ӰƱ���ҳɹ�");
			getTicket((connection.findTable(sql)));
		} else {
			System.out.println("ӰƱ����ʧ��");
		}
		connection.close();
		return tcketInformations;
	}

	/**
	 * �þ�Ŀid���ҵ�ӰƱ   ������list����ʽ��������
	 * @param sched_id
	 * @return
	 */
	public List<TcketInformation> prinfmaipiao(String sched_id) {
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ��ѯ���
		String sql = "SELECT * FROM ticket WHERE sched_id = sched_id and " +
				"ticket_status = '1'";
		if (connection.findTable(sql) != null) {
			System.out.println("ӰƱ���ҳɹ�");
			getTicket((connection.findTable(sql)));
		} else {
			System.out.println("ӰƱ����ʧ��");
		}
		connection.close();
		return tcketInformations;
	}

	/**
	 * ��ȡƱ  �ŵ�list��
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
			}// ��ʾ����
			resultSet.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ������λ��id  ��  �ݳ��ƻ���id  ��Ʊ��״̬�����޸�
	 * @param ticket_status
	 * @param seat_id
	 * @param sched_id
	 * @return
	 */
	public boolean ticketXiuGai(String ticket_status,String seat_id,
			String sched_id){
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ�Ĳ������
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
	 * ��Ʊ����
	 * @param ticket_id
	 * @return
	 */
	public boolean ticketTuipiao(String ticket_id){
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ�Ĳ������
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
