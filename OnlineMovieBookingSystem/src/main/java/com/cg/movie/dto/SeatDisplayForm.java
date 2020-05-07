package com.cg.movie.dto;

public class SeatDisplayForm {
	private int no;
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	private String seats;

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}
	public SeatDisplayForm(int no,String seat) {
		this.seats=seat;
		this.no=no;
	}

}
