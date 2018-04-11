package parking;

import junit.framework.TestCase;
import parking.car.BigCar;
import parking.car.Car;
import parking.car.SmallCar;

public class ParkingTest extends TestCase {
    Parking parking = new Parking(10,10);

    public void testPark() {
        for (int i = 0;i<10;i++) {
            Car car = new BigCar("BMW");
            assertTrue(parking.park(car));
            //carList.add(car);
        }
        for (int i = 0;i<5;i++){
            assertFalse(parking.park(new BigCar("mers")));
        }
        for (int i = 0;i<10;i++) {
            Car car = new SmallCar("Lada");
            assertTrue(parking.park(car));
            //carList.add(car);
        }
        for (int i = 0;i<5;i++){
            assertFalse(parking.park(new SmallCar("Lada")));
        }
    }

    public void testUnParc() {
        for (int i = 0;i<10;i++) {
            assertTrue(parking.park(new BigCar("BMW")));
        }
        for (int i = 0;i<10;i++) {
            assertTrue(parking.park(new SmallCar("BMW")));
        }
        for (int i = 0;i<10;i++){
            assertTrue(parking.unPark(parking.getCarList().get(i)));
        }
        for (int i = 0;i<10;i++){
            assertFalse(parking.unPark(new Car("mitsu")));
        }
    }
}