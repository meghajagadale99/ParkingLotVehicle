import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public
class ParkingLotTest {

    @Test
    void shouldReturnTrueWhenCarIsParked() throws CarAlreadyParkedException, ParkingLotFullException {
        ParkingLot parkinglot = new ParkingLot(10);
        Vehicle car = new Car();

        parkinglot.park(car);

        assertTrue(parkinglot.isParked(car));

    }


    @Test
    void shouldThrowExceptionWhenCarIsAlreadyParked() throws CarAlreadyParkedException, ParkingLotFullException {
        ParkingLot parkingSlot = new ParkingLot(10);
        Vehicle car = new Car();

        parkingSlot.park(car);

        assertThrows(CarAlreadyParkedException.class, () -> parkingSlot.park(car));
    }

    @Test
    void shouldThrowExceptionWhenParkingLotIsFull() throws ParkingLotFullException, CarAlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle car1 = new Car();
        Vehicle car2 = new Car();
        parkingLot.park(car1);

        assertThrows(ParkingLotFullException.class, () -> parkingLot.park(car2));
    }

    @Test
    void shouldReturnTrueWhenTheCarIsUnPark() throws ParkingLotFullException, CarAlreadyParkedException, CarNotFoundException {
        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle car = new Car();
        parkingLot.park(car);
        parkingLot.unPark(car);

        assertTrue(parkingLot.isUnParked(car));
    }

    @Test
    void shouldThrowCarNotFoundExceptionWhenParkingACarWhichIsAlreadyUnParked() {
        ParkingLot parkingLot = new ParkingLot(1);
        Vehicle car = new Car();

        assertThrows(CarNotFoundException.class, () -> parkingLot.unPark(car));
    }


}


