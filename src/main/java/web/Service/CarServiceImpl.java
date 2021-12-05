package web.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Dao.CarDao;
import web.Model.Car;

import java.util.List;

@Service
public class CarServiceImpl  {
    @Autowired
    private CarDao carDao;
    public List<Car> getCars(int count) {
        return carDao.carsCount(count);
        }
    }
