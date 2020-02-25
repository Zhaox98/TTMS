package com.today.math;

import java.util.ArrayList;
import java.util.List;

import com.xy.today.sql.Seat;
import com.xy.today.sql.Ticket;
import com.xy.today.util.SeatInformation;
import com.xy.today.util.TcketInformation;

/**
 * 从数据库中 得到 票的id 然后以数组的形式返回 并且 对一些 进行操作
 *
 * @author lwp940118
 *
 */
public class TicketMath {

	/**
	 * 票的 具体信息
	 */
	private List<TcketInformation> tcketInformations = new ArrayList<TcketInformation>();

	/**
	 * seat的liet
	 */
	private List<SeatInformation> seatInformations = new ArrayList<SeatInformation>();

	/**
	 * 根据演出计划的id 进行查找票的状况
	 *
	 * @param sched_id
	 */
	public int[][] ticketArray(String sched_id, String hang, String lie) {
		Ticket ticket = new Ticket();
		/**
		 * 根据剧目id 查找 返回票
		 */
		tcketInformations = ticket.prinfPlay(sched_id);
		Seat seat = new Seat();
		/**
		 * 票的数组
		 */
		int[][] tickets = new int[Integer.parseInt(hang)][Integer.parseInt(lie)];
		for (int i = 0; i < tcketInformations.size(); i++) {
			/**
			 * 根据座位id返回 座位的状态
			 */
			seatInformations = seat.prinfSeat(tcketInformations.get(i)
					.getSeat_id());
			/**
			 * 在座位未损坏的前提下 进行票的状态的设定
			 */
			if (seatInformations.get(0).getSeat_status().equals("1")) {
				tickets[Integer.parseInt(seatInformations.get(0).getSeat_row()) - 1][Integer
						.parseInt(seatInformations.get(0).getSeat_column()) - 1] = Integer
						.parseInt(tcketInformations.get(i).getTicket_status());
			} else {
				tickets[Integer.parseInt(seatInformations.get(0).getSeat_row()) - 1][Integer
						.parseInt(seatInformations.get(0).getSeat_column()) - 1] = 6;
				// 6表示 座位不存在
			}
		}

		return tickets;
	}

	/**
	 * 改变票的状态
	 * @param seat
	 * @param sched_id
	 * @param studio_id
	 * @return
	 */
	public boolean changeticket(int[][] seat, String sched_id,String studio_id) {

		/**
		 * 票操作  传回  数组正常
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
