package com.today.math;

import java.util.ArrayList;
import java.util.List;

import com.xy.today.sql.Seat;
import com.xy.today.sql.Ticket;
import com.xy.today.util.SeatInformation;
import com.xy.today.util.TcketInformation;

/**
 * �����ݿ��� �õ� Ʊ��id Ȼ�����������ʽ���� ���� ��һЩ ���в���
 *
 * @author lwp940118
 *
 */
public class TicketMath {

	/**
	 * Ʊ�� ������Ϣ
	 */
	private List<TcketInformation> tcketInformations = new ArrayList<TcketInformation>();

	/**
	 * seat��liet
	 */
	private List<SeatInformation> seatInformations = new ArrayList<SeatInformation>();

	/**
	 * �����ݳ��ƻ���id ���в���Ʊ��״��
	 *
	 * @param sched_id
	 */
	public int[][] ticketArray(String sched_id, String hang, String lie) {
		Ticket ticket = new Ticket();
		/**
		 * ���ݾ�Ŀid ���� ����Ʊ
		 */
		tcketInformations = ticket.prinfPlay(sched_id);
		Seat seat = new Seat();
		/**
		 * Ʊ������
		 */
		int[][] tickets = new int[Integer.parseInt(hang)][Integer.parseInt(lie)];
		for (int i = 0; i < tcketInformations.size(); i++) {
			/**
			 * ������λid���� ��λ��״̬
			 */
			seatInformations = seat.prinfSeat(tcketInformations.get(i)
					.getSeat_id());
			/**
			 * ����λδ�𻵵�ǰ���� ����Ʊ��״̬���趨
			 */
			if (seatInformations.get(0).getSeat_status().equals("1")) {
				tickets[Integer.parseInt(seatInformations.get(0).getSeat_row()) - 1][Integer
						.parseInt(seatInformations.get(0).getSeat_column()) - 1] = Integer
						.parseInt(tcketInformations.get(i).getTicket_status());
			} else {
				tickets[Integer.parseInt(seatInformations.get(0).getSeat_row()) - 1][Integer
						.parseInt(seatInformations.get(0).getSeat_column()) - 1] = 6;
				// 6��ʾ ��λ������
			}
		}

		return tickets;
	}

	/**
	 * �ı�Ʊ��״̬
	 * @param seat
	 * @param sched_id
	 * @param studio_id
	 * @return
	 */
	public boolean changeticket(int[][] seat, String sched_id,String studio_id) {

		/**
		 * Ʊ����  ����  ��������
		 */
		Seat seat2 = new Seat();
		Ticket ticket = new Ticket();
		int tag = 1;
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[0].length; j++) {
				if (seat[i][j] == 1||seat[i][j] == 0) {

					if (ticket.ticketXiuGai(""+seat[i][j],
							seat2.prinfPiaoSeat(studio_id, ""+(i+1),
									""+(j+1)),
							sched_id)) {
						System.out.print("i-->"+(i+1)+"   j-->"+(j+1)+"   a-->"+seat[i][j]+"\t");
					}
				}
			}
			System.out.println();
		}
		if (tag == 1) {
			return true;
		} else {
			return false;
		}
	}

}
