package com.xy.today.util;

/**
 * ��λ��Ϣ  ��get   set  ����
 * @author lwp940118
 *
 */
public class SeatInformation {

	/**
	 * ��λid
	 */
	private String seat_id;
	/**
	 * �����ݳ�����id
	 */
	private String studio_id;
	/**
	 * ��λ���к�
	 */
	private String seat_row;
	/**
	 * ��λ���к�
	 */
	private String seat_column;
	/**
	 * ��λ  ��״̬
	 */
	private String seat_status;
	
	public String getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(String seat_id) {
		this.seat_id = seat_id;
	}
	public String getStudio_id() {
		return studio_id;
	}
	public void setStudio_id(String studio_id) {
		this.studio_id = studio_id;
	}
	public String getSeat_row() {
		return seat_row;
	}
	public void setSeat_row(String seat_row) {
		this.seat_row = seat_row;
	}
	public String getSeat_column() {
		return seat_column;
	}
	public void setSeat_column(String seat_column) {
		this.seat_column = seat_column;
	}
	public String getSeat_status() {
		return seat_status;
	}
	public void setSeat_status(String seat_status) {
		this.seat_status = seat_status;
	}
	
}
