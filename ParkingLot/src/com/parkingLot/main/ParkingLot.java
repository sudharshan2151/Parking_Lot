package com.parkingLot.main;

import java.util.Scanner;

import com.parkingLot.Service.ParkingService;
import com.parkingLot.model.Vehicle;
import com.parkingLot.model.VehicleType;

public class ParkingLot {

	private Scanner scanner;
	private ParkingService parkingService;

	public ParkingLot(ParkingService parkingService) {
		super();
		this.scanner=new Scanner(System.in);
		this.parkingService = parkingService;
	}
	
	
	public void start() {
		System.out.println(" Welcome to Parking lot System ");
		while(true) {
			try {
				System.out.println(" 1 : Create the Parking lot ");
				System.out.println(" 2 : Display free_count ");
				System.out.println(" 3 : Display free_slots ");
				System.out.println(" 4 : unpark ");
				System.out.println(" 5 : Park the Vehicle ");
				System.out.println(" 6 : Occupied slots ");
				System.out.println(" 7 : Exit ");
				int choice = Integer.parseInt(scanner.nextLine());
				switch(choice) {
				case 1:
					createParkingLot(scanner);
					break;
				case 2:
					displayFreeCount();
					break;
				case 3:
					displayFreeSlot();
					break;
				case 4:
					unpark();
					break;
				case 5:
					parkVehicle();
					break;
				case 6:
					occupiedSlot();
					break;
				case 7:
					return;
				default:
					System.out.println("Invalid Input ");
					break;
				}
			}
			catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
		
	}


	private void occupiedSlot() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Vehicle Type");
		String type = scanner.nextLine();
		parkingService.occupiedSlotsCount(VehicleType.valueOf(type));
	}


	private void parkVehicle() {
		// TODO Auto-generated method stub
		System.out.println("Enter the vehicle Type");
		VehicleType valueOf = VehicleType.valueOf(scanner.nextLine());
		System.out.println("Enter the Regno");
		String name = scanner.nextLine();
		System.out.println("Enter the color");
		String color = scanner.nextLine();
		Vehicle vehicle = new Vehicle(name, valueOf,color);
		parkingService.addVehicle(vehicle);
		
	}


	private void unpark() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Ticket ID");
		String vehicle = scanner.nextLine();
		parkingService.unpark(vehicle);
	}


	private void displayFreeSlot() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Vehicle Type");
		String type = scanner.nextLine();
		parkingService.freeSlots(VehicleType.valueOf(type));
	}


	private void displayFreeCount() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Vehicle Type");
		String type = scanner.nextLine();
		parkingService.freeSlotsCount(VehicleType.valueOf(type));
	}


	private void createParkingLot(Scanner scanner2) {
		// TODO Auto-generated method stub
		System.out.println("Enter the parking Id");
		String parkingId = scanner.nextLine().toLowerCase();
		System.out.println("Enter no of floors");
		int floor = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter no of slots per floor");
		int slots = Integer.parseInt(scanner.nextLine());
		parkingService.addParkingLot(parkingId, floor, slots);
	}
	
}
