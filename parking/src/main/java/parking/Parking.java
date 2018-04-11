package parking;

import parking.car.BigCar;
import parking.car.Car;
import parking.car.SmallCar;

import java.util.ArrayList;
import java.util.List;

class Parking {
    private int smallSpace;
    private int bigSpace;
    private List<Car> carList = new ArrayList<>();

    Parking(int smallSpace, int bigSpace) {
        this.smallSpace = smallSpace;
        this.bigSpace = bigSpace;
    }

    boolean park(Car car) {
        if (car instanceof BigCar) {
            if (bigSpace == 0) {
                return false;
            } else {
                carList.add(car);
                bigSpace--;
            }
        } else if (car instanceof SmallCar) {
            if (smallSpace == 0) {
                return false;
            } else {
                carList.add(car);
                smallSpace--;
            }
        }
        return true;
    }

    boolean unPark(Car car) {
        if (carList.contains(car)) {
            carList.remove(car);
            if (car instanceof BigCar) {
                bigSpace++;
            } else if (car instanceof SmallCar) {
                smallSpace++;
            }
            return true;
        } else return false;
    }
    //region getters and setters

    public List<Car> getCarList() {
        return carList;
    }

    //endregion

}
