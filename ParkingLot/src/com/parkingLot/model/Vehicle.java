package com.parkingLot.model;

public class Vehicle {
	
	String name;
	VehicleType vehicle;
	String color;
	String ticketId;
	
	
	public Vehicle(String name, VehicleType vehicle, String color) {
		super();
		this.name = name;
		this.vehicle = vehicle;
		this.color = color;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public VehicleType getVehicle() {
		return vehicle;
	}
	public void setVehicle(VehicleType vehicle) {
		this.vehicle = vehicle;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	@Override
	public String toString() {
		return String.format("Vehicle [name=%s, vehicle=%s, color=%s, ticketId=%s]", name, vehicle, color, ticketId);
	}
	
	
	
	

}
