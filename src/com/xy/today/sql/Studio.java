package com.xy.today.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xy.today.util.PlayInformation;
import com.xy.today.util.StudioInformation;

/**
 * �ݳ������  ����  ���ݿ�  ����
 *
 */
public class Studio {

	/**
	 * listΪstudio�Ļ�ȡ����Ϣ��sql��ѯ���ȡ��list
	 */
	private List<StudioInformation> studio = new ArrayList<StudioInformation>();

	/**
	 * ���ݿⶨ��
	 */

	private MovieConnection connection = null;

	/**
	 * studio ������
	 * @param name
	 * @param hang
	 * @param lie
	 * @param infor
	 * @param keyong
	 * @return
	 */
	public String studioAdd(String name,String hang,String lie,String infor
			,Boolean keyong){
		String id = "";
		connection = new MovieConnection(); // �������ݿ�
		String sql = "insert into studio(studio_name,studio_row_count,studio_col_count," +
				"studio_introduction,studio_isavailable) values('"+name+"','"+hang+"','"+lie+"','"
				+infor+"','"+keyong+"')";
		if (connection.insertTable(sql)) {
			
			String sql_id = "SELECT studio_id\n" + "FROM studio";
			id = seatAddReturnId((connection.findTable(sql_id)));
			connection.close();
			return id;
		} else {
			System.out.println("studio ���ʧ��");
		}
		connection.close();
		return id;
	}

	/**
	 * studio  �� Ԫ�ص��޸� ����
	 * @param name
	 * @param hang
	 * @param lie
	 * @param infor
	 * @param keyong
	 * @param id
	 * @return
	 */
	public boolean studioXiuGai(String name,String hang,
			String lie,String infor,String keyong,String id){
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ�Ĳ������
		System.out.println("id = " + id );
		String sql = "UPDATE studio SET studio_name = '"+name+
				"',studio_row_count = '"+hang+"',studio_col_count = '"+lie+
				"',studio_introduction = '"+infor+"',studio_isavailable = '"+keyong+"'"
				+" WHERE studio_id = "+id;
		if (connection.updateTable(sql)) {
			connection.close();
			return true;
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
	public List<StudioInformation> prinfStudios() {
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ��ѯ���
		String sql = "SELECT * FROM studio";
		if (connection.findTable(sql) != null) {
			System.out.println("studio���ȡ�ɹ�");
			getStudio((connection.findTable(sql)));
		} else {
			System.out.println("studio����û������");
		}
		connection.close();
		return studio;
	}

	/**
	 * ͨ��id  ��   ���ݿ��л�ȡ���ұ���
	 * ��ȡ�õ�list����  Ȼ����а�
	 * ��ȡ���� Ա��
	 * @param no
	 * @return
	 */
	public List<StudioInformation> prinfStudio(String studio_id) {
		//System.out.println("fanlin");
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ��ѯ���
		String sql = "SELECT * FROM studio WHERE studio_id = + studio_id";
		if (connection.findTable(sql) != null) {
			System.out.println("studio���ȡ�ɹ�");
			getStudio((connection.findTable(sql)));
		} else {
			System.out.println("studio����û������");
		}
		connection.close();
		return studio;
	}

	/**
	 * ��ȡpaly�����Ϣ ���ұ�����list�б���
	 *
	 *
	 *
	 * @param resultSet
	 * @return
	 */
	public void getStudio(ResultSet resultSet) {

		try {
			studio = new ArrayList<StudioInformation>();
			StudioInformation studioInformation;
			while (resultSet.next()) {
				studioInformation = new StudioInformation();
				//��Ŀid
				studioInformation.setStudio_id((resultSet.getString(1)));
				//����
				studioInformation.setStudio_name((resultSet.getString(2)));

				studioInformation.setStudio_row_count((resultSet.getString(3)));

				studioInformation.setStudio_col_count((resultSet.getString(4)));

				studioInformation.setStudio_introduction((resultSet.getString(5)));

				studioInformation.setStudio_isavailable((resultSet.getString(6)));

				studio.add(studioInformation);
			}// ��ʾ����
			resultSet.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�ݳ���������Ϣ���ݲ�ѯ����");
		}
	}

	/**
	 * ���ݹ���ɾ����Ŀ����Ϣ  �б�
	 * @param id
	 * @return
	 */
	public boolean DeleteStudio(String id){
		connection = new MovieConnection(); // �������ݿ�
		String sql = "DELETE FROM studio WHERE studio_id = '"+id+"'";
		if (connection.deleteTable(sql)) {
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}

	/**
	 * ��ӳ�����  �ɹ�ʱ ���ط�ӳ��  �� id
	 * @param resultSet
	 * @return
	 */
	private String seatAddReturnId(ResultSet resultSet){
		String string = "";
		try {
			while (resultSet.next()) {
				string = resultSet.getString(1);
				//System.out.println(emp_password);
			}// ��ʾ����
			resultSet.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ע����� ����IDʱ����");
		}
		return string;
	}

}
