import java.util.HashSet;

public class ParkingLot {

    private final int capacity;
    private int counter = 0;
    private final HashSet<Vehicle> listOfVehicles = new HashSet<Vehicle>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public boolean isParked(Vehicle car) {
        return listOfVehicles.contains(car);
    }

    public void park(Vehicle vehicle) throws CarAlreadyParkedException, ParkingLotFullException {
        if (isParked(vehicle))
            throw new CarAlreadyParkedException("Car is already parked");
        if (counter < capacity) {
            listOfVehicles.add(vehicle);
            counter++;
        } else {
            throw new ParkingLotFullException("Parking lot capacity  is already full");
        }
    }

    public void unPark(Vehicle car) throws CarNotFoundException {
        if(listOfVehicles.contains(car))
            listOfVehicles.remove(car);
        else
            throw new CarNotFoundException("Car does not exits in parking lot");
    }

    public boolean isUnParked(Vehicle car){
        return !listOfVehicles.contains(car);
    }
}