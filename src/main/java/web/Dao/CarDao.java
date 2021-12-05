package web.Dao;

import org.springframework.stereotype.Repository;
import web.Model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDao {
    private static final List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car("Lexus", "LF C", 10));
        cars.add(new Car("BMW", "7 Series", 5));
        cars.add(new Car("Aston Martin", "Vanquish", 20));
        cars.add(new Car("Audi", " E-tron Quattro", 15));
        cars.add(new Car("Mercedes", " CLS", 17));
    }

    public static List<Car> carsCount(int count) {
        if (count > 0 && count <= 5) {
            return cars.stream().limit(count).collect(Collectors.toList());
        } else {
            return cars;
        }
    }
}
