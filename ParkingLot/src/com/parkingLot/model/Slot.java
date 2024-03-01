package com.parkingLot.model;

public class Slot {
	VehicleType vehicle;
	boolean parkStatus;
	String vehicleName;
	
	
	
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public VehicleType getVehicle() {
		return vehicle;
	}
	public void setVehicle(VehicleType vehicle) {
		this.vehicle = vehicle;
	}
	public boolean isParkStatus() {
		return parkStatus;
	}
	public void setParkStatus(boolean parkStatus) {
		this.parkStatus = parkStatus;
	}
	
	public Slot(VehicleType vehicle, boolean parkStatus) {
		super();
		this.vehicle = vehicle;
		this.parkStatus = parkStatus;
		
	}
	@Override
	public String toString() {
		return String.format("Slot [vehicle=%s, parkStatus=%s, vehicleName=%s]", vehicle, parkStatus, vehicleName);
	}
	
	
	

	
}
