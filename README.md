# Parking Lot System 🅿️

This project aims to design a next-generation parking lot system capable of managing a parking lot without any human intervention. The system is implemented as a command-line application with various functionalities.

## Requirements

- Create the parking lot.
- Add floors to the parking lot.
- Add a parking lot slot to any of the floors.
- Park a vehicle and generate a ticket.
- Unpark a vehicle using the ticket ID.
- Display the number of free slots per floor for a specific vehicle type.
- Display all the free slots per floor for a specific vehicle type.
- Display all the occupied slots per floor for a specific vehicle type.

## Details

### Vehicles
- Every vehicle has a type, registration number, and color.
- Different types of vehicles include Car, Bike, and Truck.

### Parking Slots
- Each type of slot can park a specific type of vehicle.
- Slots are numbered serially from 1 to n for each floor.

### Parking Lot Floors
- Numbered serially from 1 to n.
- May contain one or more parking lot slots of different types.

### Tickets
- The ticket ID format: `<parking_lot_id>_<floor_no>_<slot_no>`

## Input/Output Format

### Input Format
- Commands: `create_parking_lot`, `park_vehicle`, `unpark_vehicle`, `display`, `exit`

### Output Format
- Output based on specific commands.


## Expectations

- Working and demonstrable code.
- Functionally correct.
- Modular and readable code.
- Separation of concerns.
- Easily accommodates new requirements and minimal changes.
- Main method for easy testability.
- Optional: Unit tests.
- No GUI required.

## Optional Requirements

- Extensible for additional vehicle and slot types.
- Extensible for different slot allocation strategies.
- Extensible for other command types.
- Extensible for multiple parking lots.
- Thread-safe implementation for concurrent requests.



