package com.today.math;

import java.util.ArrayList;
import java.util.List;

import com.xy.today.sql.Seat;
import com.xy.today.util.SeatInformation;

/**
 * ��λ  �ļ���  �����ݿ��ж�ȡ��λ������ Ȼ�󷵻� int����
 * @author lwp940118
 *
 */
public class SeatMath {

	private List<SeatInformation> informations = new ArrayList<SeatInformation>();
	/**
	 * �����ݿ��ж�ȡ  ��λ������  Ȼ�󷵻�   int������
	 * @param id
	 * @param hang
	 * @param lie
	 * @return
	 */
	public int[][] seatMath(String id,String hang,String lie){
		Seat seat = new Seat();
		informations = seat.prinfSeats(id);
		int hangnum = Integer.parseInt(hang);
		int lienum = Integer.parseInt(lie);
		int[][] seatinfor = new int[hangnum][lienum];
		for (int i = 0; i < informations.size(); i++) {
			int seathang = Integer.parseInt(informations.get(i).getSeat_row());
			int seatlie = Integer.parseInt(informations.get(i).getSeat_column());
			int seatzhuang = Integer.parseInt(informations.get(i).getSeat_status());

			seatinfor[seathang-1][seatlie-1] = seatzhuang;
		}
		return seatinfor;
	}

	/**
	 * �ı���λ ��״̬
	 * @param seat
	 * @param id
	 * @return
	 */
	public boolean changeSeat(int[][] seat,String id){

		Seat seat2 = new Seat();
		int tag = 1;
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[0].length; j++) {
				if (seat2.seatXiuGai(id, ""+(i+1), ""+(j+1),""+seat[i][j])) {
					//System.out.println("�޸ĳɹ�");
					tag = 1;
				}else {
					//System.out.println("�޸�ʧ��");
					tag = 0;
				}
			}
		}
		if (tag == 1) {
			return true;
		}else {
			return false;
		}
	}

}
