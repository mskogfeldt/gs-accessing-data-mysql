package starcheck.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starcheck.dao.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    public RestaurantRepository restaurantRepository;

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    public  List<Restaurant> getByName(String name){
        return restaurantRepository.findByName(name);
    }
}
