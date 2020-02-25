package com.xy.today.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xy.today.util.PlayInformation;

/**
 * ���ݿ�   ��  play���һЩ  �����Ĳ���
 * @author lwp940118
 *
 */
public class Play {

	/**
	 * listΪplay�Ļ�ȡ����Ϣ��sql��ѯ���ȡ��list
	 */
	private List<PlayInformation> play = new ArrayList<PlayInformation>();

	/**
	 * ���ݿⶨ��
	 */
	private MovieConnection connection = null;


	/**
	 * ͨ��id  ��   ���ݿ��л�ȡ���ұ���
	 * ��ȡ�õ�list����  Ȼ����а�
	 * ��ȡ��� Ա��
	 * @param no
	 * @return
	 */
	public List<PlayInformation> prinfPlays() {
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ��ѯ���
		String sql = "SELECT * FROM play";
		if (connection.findTable(sql) != null) {
			System.out.println("play���ȡ�ɹ�");
			getplay((connection.findTable(sql)));
		} else {
			System.out.println("play����û������");
		}
		connection.close();
		return play;
	}

	/**
	 * ͨ��id  ��   ���ݿ��л�ȡ���ұ���
	 * ��ȡ�õ�list����  Ȼ����а�
	 * ��ȡ���� Ա��
	 * @param no
	 * @return
	 */
	public List<PlayInformation> prinfPlay(String paly_id) {
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ��ѯ���
		String sql = "SELECT * FROM play WHERE play_id = '"+paly_id+"'";
		if (connection.findTable(sql) != null) {
			System.out.println("paly���ȡ�ɹ�");
			getplay((connection.findTable(sql)));
		} else {
			System.out.println("play����û������");
		}
		connection.close();
		return play;
	}

	/**
	 * ��ȡpaly�����Ϣ ���ұ�����list�б���
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
				//��Ŀid
				playInformation.setPlay_id((resultSet.getString(1)));
				//����id
				playInformation.setPlay_type_id(resultSet.getString(2));
				//����
				playInformation.setPlay_lang_id(resultSet.getString(3));
				//paly����
				playInformation.setPlay_name(resultSet.getString(4));
				//����
				playInformation.setPlay_introduction(resultSet.getString(5));
				//ͼƬ
				playInformation.setPlay_image(resultSet.getString(6));
				//ʱ��
				playInformation.setPlay_length(resultSet.getString(7));
				//Ʊ��
				playInformation.setPlay_ticket_price(resultSet.getString(8));
				//״̬
				playInformation.setPlay_status(resultSet.getString(9));

				play.add(playInformation);
			}// ��ʾ����
			resultSet.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("play����Ϣ���ݲ�ѯ����");
		}
	}
	/**
	 * ���  ��Ŀ��һЩ��Ϣ
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

		connection = new MovieConnection(); // �������ݿ�
		String sql = "insert into play(play_type_id,play_lang_id,play_name," +
				"play_introduction,play_image,play_length,play_ticket_price," +
				"play_status) values('"+leixing+"','"+yuyan+"','"+name+"','"
				+infro+"','"+image+"','"+shichang+"','"+piaojia+"','"+
				zhuangtai+"')";
		if (connection.insertTable(sql)) {
			System.out.println("Ա����Ϣע��ɹ�");
			connection.close();
			return true;
		} else {
			System.out.println("Ա����Ϣע��ʧ��");
		}
		connection.close();
		return false;
	}

	/**
	 * ���ݹ���ɾ����Ŀ����Ϣ  �б�
	 * @param id
	 * @return
	 */
	public boolean DeletePlay(String id){
		connection = new MovieConnection(); // �������ݿ�
		String sql = "DELETE FROM play WHERE play_id = '"+id+"'";
		if (connection.deleteTable(sql)) {
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}

	/**
	 * play  ���޸�  ����
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
		connection = new MovieConnection(); // �������ݿ�
		//���ݿ�Ĳ������
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
