package com.timediff.exe;

import com.timediff.model.MyTicket;
import com.timediff.service.CalculateTimeDifference;

public class RunIt {

	public static void main(String[] args) {
		CalculateTimeDifference cTimeDiffObj= new CalculateTimeDifference();
		MyTicket myTicketObj=new MyTicket();
		myTicketObj.setTicketNumer("123");
		cTimeDiffObj.calculateWorkingHours(startDate, endDate, d3);
		System.out.println(cTimeDiffObj.getResolutionTime(myTicketObj));
	}

}
