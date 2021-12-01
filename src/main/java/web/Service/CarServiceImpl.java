package web.Service;


import org.springframework.stereotype.Service;
import web.Model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImpl  {
     public static List<Car> carsCount(List<Car> list, int count) {
        if (count > 0 && count <= 5) {
            return list.stream().limit(count).collect(Collectors.toList());
        } else {
            return list;
        }
    }
}
