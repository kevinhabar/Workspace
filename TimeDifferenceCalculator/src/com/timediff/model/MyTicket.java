package com.timediff.model;

public class MyTicket {
	private String ticketNumer;
	private boolean isTicketResolved;
	private TicketTime mytimeObjects;
	public String getTicketNumer() {
		return ticketNumer;
	}
	public void setTicketNumer(String ticketNumer) {
		this.ticketNumer = ticketNumer;
	}
	public boolean isTicketResolved() {
		return isTicketResolved;
	}
	public void setTicketResolved(boolean isTicketResolved) {
		this.isTicketResolved = isTicketResolved;
	}
	public TicketTime getMytimeObjects() {
		return mytimeObjects;
	}
	public void setMytimeObjects(TicketTime mytimeObjects) {
		this.mytimeObjects = mytimeObjects;
	}
	



}
