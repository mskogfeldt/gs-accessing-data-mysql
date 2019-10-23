package starcheck.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starcheck.business.RestaurantService;
import starcheck.business.Restaurant;


import java.util.List;

@RestController
@RequestMapping(path="/starcheck/rs")
public class RestaurantRestController {

    @Autowired
    public RestaurantService restaurantService;

    @GetMapping(path="/all")
    List<Restaurant> getAll() {
        return restaurantService.getAll();
    }

    @GetMapping(path="/demo")
    Restaurant getDemo(){
        return new Restaurant(1, "PizzaHut");
    }


    @GetMapping(path = "/find/{name}")
    public List<Restaurant> getByName(@PathVariable ("name") String name){
        return  restaurantService.getByName(name);
    }
}
