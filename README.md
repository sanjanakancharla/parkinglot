# Parking Lot Low-Level Design (LLD)

## Core Objects

### 1. ParkingSpot
Represents an individual space where a vehicle can be parked. It typically contains attributes like:
* `spotId` (Unique identifier)
* `isAvailable` (Boolean flag)
* `vehicleTypeSupported` (e.g., CAR, BIKE, TRUCK)
* `vehicle` (Reference to the currently parked vehicle, if any)

### 2. Vehicle
Represents any vehicle entering the parking lot.
* `licensePlate` (Unique identifier)
* `vehicleType` (Enum: CAR, BIKE, TRUCK, etc.)

### 3. ParkingManager
Responsible for managing parking spots. It handles:
* Finding and allocating an available spot based on vehicle type.
* Releasing a spot when a vehicle exits.
* Tracking the overall capacity and utilization of the lot.

### 4. Ticket & Pricing System (Strategy Design Pattern)
Manages the entry/exit records and calculates costs dynamically based on the **Strategy Design Pattern**.

* **Ticket**: Contains data such as `ticketId`, `allocatedSpot`, `entryTime`, and `exitTime`.
* **Fare Strategy Interface**: Defines a common method (e.g., `calculateFare(duration)`) implemented by different pricing models.
* **BaseFareStrategy**: A concrete strategy implementing standard, flat-rate pricing.
* **PeakHourFareStrategy**: A concrete strategy implementing surge pricing or higher rates during heavy traffic hours.
* **Fare Calculator**: Uses the configured strategy to compute the total price when a vehicle exits.

### 5. ParkingLot (Facade Design Pattern)
Acts as a **Facade**, providing a clean, unified, and simplified interface for clients (such as entry/exit gates or system operators) to interact with the system. 
* It hides inner complexities by delegating complex logic behind the scenes.
* It relies on the `ParkingManager` for spot allocation and the `FareCalculator` for dynamic pricing,managing the flow of vehicles through entry and exit operations.

