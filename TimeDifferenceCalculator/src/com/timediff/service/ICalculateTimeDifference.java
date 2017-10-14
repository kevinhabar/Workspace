package com.timediff.service;

import java.util.Date;

import com.timediff.model.MyTicket;

public interface ICalculateTimeDifference {
	public Date getResolutionTime(MyTicket tkt);
	public MyTicket getTicketDEtails(MyTicket tktDetails);

}
