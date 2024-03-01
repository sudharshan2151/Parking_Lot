package com.parkingLot.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.parkingLot.model.Slot;
import com.parkingLot.model.Vehicle;

public class ParkingLotRepository {

	
	
	Map<String,List<List<Slot>>> parkingLot;
	Map<String,Vehicle> vehicles;
	
	
	public void addParkingLot(String parkingId,List<List<Slot>> list) {
		parkingLot.put(parkingId, list);
	}
	
	
	public Map<String,List<List<Slot>>> getParkingLot(){
		return parkingLot;
	}

	public ParkingLotRepository() {
		this.parkingLot = new HashMap<>();
		this.vehicles = new HashMap<>();
		
	}
	public void addVehicles(Vehicle vehicle) {
		vehicles.put(vehicle.getName(), vehicle);
	}
	
	public boolean containsVehicle(String name) {
		return vehicles.containsKey(name);
	}
	
	public void remove(String name) {
		vehicles.remove(name);
	}
	
	
	public Vehicle getVehicle(String name) {
		return vehicles.get(name);
	}
	
}
