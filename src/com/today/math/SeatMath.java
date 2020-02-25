package com.today.math;

import java.util.ArrayList;
import java.util.List;

import com.xy.today.sql.Seat;
import com.xy.today.util.SeatInformation;

/**
 * 座位  的计算  从数据库中读取座位的数据 然后返回 int数组
 * @author lwp940118
 *
 */
public class SeatMath {

	private List<SeatInformation> informations = new ArrayList<SeatInformation>();
	/**
	 * 从数据库中读取  座位的数据  然后返回   int行整数
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
	 * 改变座位 的状态
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
					//System.out.println("修改成功");
					tag = 1;
				}else {
					//System.out.println("修改失败");
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
