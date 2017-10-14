package com.timediff.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.timediff.model.MyTicket;
import com.timediff.model.TicketTime;

public class CalculateTimeDifference implements ICalculateTimeDifference{

	@Override
	public Date getResolutionTime(MyTicket tkt) {
		String ticketNumber=tkt.getTicketNumer();
		Date startDate=tkt.getMytimeObjects().getTicketStartDate();
		Date endDate=tkt.getMytimeObjects().getTicketEndDate();
		int x=calculateWorkingHours(startDate,endDate,null);
		return null;
	}

	@Override
	public MyTicket getTicketDEtails(MyTicket tktDetails) {
		MyTicket tktDetailsTemp= new MyTicket();
		//HArdcoding TicketTime for instance.
		TicketTime ticketTime= new TicketTime();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = "10/10/2017";
		Date startDateTime = null;
		try {
			startDateTime = sdf.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date endDateTime= new Date();
		ticketTime.setTicketStartDate(startDateTime);
		ticketTime.setTicketEndDate(endDateTime);

		
		tktDetailsTemp.setMytimeObjects(ticketTime);
		// TODO Auto-generated method stub
		return tktDetailsTemp;
	}
	public int calculateWorkingHours(Date startDate, Date endDate,Date d3[])
	{
		Calendar startCal = Calendar.getInstance();
	    startCal.setTime(startDate);        

	    Calendar endCal = Calendar.getInstance();
	    endCal.setTime(endDate);

	    int workDays = 0;

	    //Return 0 if start and end are the same
	    if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
	        return 0;
	    }
	    if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
	        startCal.setTime(endDate);
	        endCal.setTime(startDate);
	    }

	    do {
	       //excluding start date
	        startCal.add(Calendar.DAY_OF_MONTH, 1);
	        if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
	        	
	        	for(int i=0;i<d3.length;i++)
	        	{
	        		if(Calendar.YEAR!=d3[i].getYear() & Calendar.MONTH!=d3[i].getMonth() & Calendar.DATE!=d3[i].getDate())
	    	            ++workDays;
	        	}
	        }
	    } while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); //excluding end date
	    
        int resolutionHours=0;
        if (workDays==0) {
            	resolutionHours=(int) (endCal.getTimeInMillis()- startCal.getTimeInMillis())/3600000;
        }
        else
        {
        	resolutionHours=((int) (endCal.getTimeInMillis()- startCal.getTimeInMillis())/3600000)-17*workDays;
        }
	    return resolutionHours;
	}
}
