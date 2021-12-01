package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.Car;
import web.Service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller

public class CarController {
    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", defaultValue = "5") byte count, Model model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Lexus", "LF C", 10));
        cars.add(new Car("BMW", "7 Series", 5));
        cars.add(new Car("Aston Martin", "Vanquish", 20));
        cars.add(new Car("Audi", " E-tron Quattro", 15));
        cars.add(new Car("Mercedes", " CLS", 17));
        cars = CarServiceImpl.carsCount(cars, count);
        model.addAttribute("cars", cars);
        return "cars";
    }
}


