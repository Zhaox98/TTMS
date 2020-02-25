package com.xy.today.util;

/**
 * 票的一些 信息状态 及其属性设置
 * 
 * @author lwp940118
 * 
 */
public class TcketInformation {

	// 票的id
	private String ticket_id;
	// 座位的id
	private String seat_id;
	// 演出计划的id'
	private String sched_id;
	// 票的价格
	private String ticket_price;
	// 票的状态
	private String ticket_status;

	public String getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getSeat_id() {
		return seat_id;
	}

	public void setSeat_id(String seat_id) {
		this.seat_id = seat_id;
	}

	public String getSched_id() {
		return sched_id;
	}

	public void setSched_id(String sched_id) {
		this.sched_id = sched_id;
	}

	public String getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(String ticket_price) {
		this.ticket_price = ticket_price;
	}

	public String getTicket_status() {
		return ticket_status;
	}

	public void setTicket_status(String ticket_status) {
		this.ticket_status = ticket_status;
	}

}
