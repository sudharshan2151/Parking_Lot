package com.parkingLot.config;

import com.parkingLot.Repository.ParkingLotRepository;
import com.parkingLot.Service.ParkingService;
import com.parkingLot.main.ParkingLot;

public class ParkingLotConfig {
	
	public static void main(String[] args) {
		ParkingLotRepository parkLotRepository = new ParkingLotRepository();
		ParkingService parkingService = new ParkingService(parkLotRepository);
		ParkingLot parkingLot = new ParkingLot(parkingService);
		parkingLot.start();
	}

}
