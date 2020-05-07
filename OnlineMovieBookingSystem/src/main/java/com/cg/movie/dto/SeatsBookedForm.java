package com.cg.movie.dto;

public class SeatsBookedForm {
	int seatNo;

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public SeatsBookedForm(int seatNo)
	{
		this.seatNo=seatNo;
	}

}
