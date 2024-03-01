package com.parkingLot.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import com.parkingLot.Exception.InvalidTicketException;
import com.parkingLot.Exception.InvalidVehicleName;
import com.parkingLot.Exception.ParkingIdFoundException;
import com.parkingLot.Repository.ParkingLotRepository;
import com.parkingLot.model.Slot;
import com.parkingLot.model.Vehicle;
import com.parkingLot.model.VehicleType;

public class ParkingService {

	private ParkingLotRepository parkingLotRepository;

	public ParkingService(ParkingLotRepository parkingLotRepository) {
		this.parkingLotRepository = parkingLotRepository;
	}
	
	public void addParkingLot(String parkingId,int floor, int slot) {
		parkingId=parkingId.toUpperCase();
		if(parkingLotRepository.getParkingLot().containsKey(parkingId)) {
			throw new ParkingIdFoundException("Already parking lot exits with the Id "+parkingId);

		}
		
		List<List<Slot>> parkingLot = new ArrayList<>();
		for(int i=0;i<floor;i++) {
			List<Slot> lot = new ArrayList<>();
			
			VehicleType[] type = {VehicleType.BIKE,VehicleType.CAR,VehicleType.TRUCK};
			for(int j=0;j<slot;j++) {
				if(j==0) {
					Slot slot1 = new Slot(type[2],true);
					lot.add(slot1);
				}
				else if(j==1 || j==2) {
					Slot slot1 = new Slot(type[0],true);
					lot.add(slot1);
				}
				else {
					Slot slot1 = new Slot(type[1],true);
					lot.add(slot1);
				}
			}
			
			parkingLot.add(lot);
		}
		
		parkingLotRepository.addParkingLot(parkingId, parkingLot);
		//System.out.println(parkingLotRepository.getParkingLot());
		System.out.println("Created Parking Lot "+ floor +" floors "+slot+" slots per floor ");
	}
	
	public void addVehicle(Vehicle vehicle) {
		if(parkingLotRepository.containsVehicle(vehicle.getName())) {
			throw new InvalidVehicleName("Invalid Vehicle Name");
		}
		Map<String, List<List<Slot>>> parkingLot = parkingLotRepository.getParkingLot();
		for(String a : parkingLot.keySet()) {
			List<List<Slot>> list = parkingLot.get(a);
			for(int i=0;i<list.size();i++) {
				for(int j=0;j<list.get(i).size();j++) {
					Slot slot = list.get(i).get(j);
					if(slot.getVehicle().equals(vehicle.getVehicle())&&slot.isParkStatus()) {             
						slot.setParkStatus(false);
						slot.setVehicleName(vehicle.getName());
						vehicle.setTicketId("Parked Vehicle : Ticket-ID " + a +"_"+(i+1)+"_"+(j+1));
						parkingLotRepository.addVehicles(vehicle);
						System.out.println("Parked Vehicle : Ticket-ID " + a +"_"+(i+1)+"_"+(j+1));
						return ;
					}
				}
			}
		}
		System.out.println("Parking Lot Full");
	}
	
	public void freeSlotsCount(VehicleType type) {
		Map<String, List<List<Slot>>> parkingLot = parkingLotRepository.getParkingLot();
		for(String a : parkingLot.keySet()) {
			List<List<Slot>> list = parkingLot.get(a);
			for(int i=0;i<list.size();i++) {
				int count = 0;
				for(int j=0;j<list.get(i).size();j++) {
					Slot slot = list.get(i).get(j);
					if(slot.getVehicle().equals(type)&&slot.isParkStatus()) {             
						count++;
					}
				}
				System.out.println("No of free slots for "+type+" on floor "+(i+1)+" "+count);
			}
		}
	}
	
	public void occupiedSlotsCount(VehicleType type) {
		Map<String, List<List<Slot>>> parkingLot = parkingLotRepository.getParkingLot();
		for(String a : parkingLot.keySet()) {
			List<List<Slot>> list = parkingLot.get(a);
			for(int i=0;i<list.size();i++) {
				int count = 0;
				for(int j=0;j<list.get(i).size();j++) {
					Slot slot = list.get(i).get(j);
					if(slot.getVehicle().equals(type)&&!slot.isParkStatus()) {             
						count++;
					}
				}
				System.out.println("Occupied slots for "+type+" on floor "+(i+1)+" : "+count);
			}
		}
	}
	
	public void unpark(String ticketId) {
		Map<String, List<List<Slot>>> parkingLot = parkingLotRepository.getParkingLot();
		try {
			String[] ar = ticketId.trim().split("\\_");
			
			if(parkingLot.containsKey(ar[0])) {
				int parseInt = Integer.parseInt(ar[1]);
				int parseInt2 = Integer.parseInt(ar[2]);
				List<List<Slot>> list = parkingLot.get(ar[0]);
			
				List<Slot> list2 = list.get(parseInt-1);
				Slot slot = list2.get(parseInt2-1);
				System.out.println(slot);
				slot.setParkStatus(true);
				Vehicle vehicle = parkingLotRepository.getVehicle(slot.getVehicleName());
				System.out.println("Unparked vehicle with Registration Number : "+ slot.getVehicleName()+" "+vehicle.getColor());
				parkingLotRepository.remove(slot.getVehicleName());
				return;
			}
			throw new InvalidTicketException("Invalid TicketID");
			
		}
		catch(RuntimeException ex) {
			throw new InvalidTicketException("Invalid TicketID");
		}
	}
	
	public void freeSlots(VehicleType type) {
		Map<String, List<List<Slot>>> parkingLot = parkingLotRepository.getParkingLot();
		for(String a : parkingLot.keySet()) {
			List<List<Slot>> list = parkingLot.get(a);
			for(int i=0;i<list.size();i++) {
				StringJoiner ans = new StringJoiner(",");
				for(int j=0;j<list.get(i).size();j++) {
					Slot slot = list.get(i).get(j);
					if(slot.getVehicle().equals(type)&&slot.isParkStatus()) {             
						ans.add((j+1)+"");
					}
				}
				System.out.println("No of free slots for "+type+" on floor "+(i+1)+" : "+ans);
			}
		}
	}
	
}
