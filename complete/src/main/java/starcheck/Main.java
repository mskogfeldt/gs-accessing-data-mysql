package starcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import starcheck.business.DishRecommendation;
import starcheck.business.Restaurant;
import starcheck.dao.DishRecommendationRepository;
import starcheck.dao.RestaurantRepository;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    DishRecommendationRepository dishRecommendationRepository;

    @Bean
    public CommandLineRunner hello() {
        return (args) -> {

            Restaurant r = new Restaurant(1, "Bankomat");
            DishRecommendation dr = new DishRecommendation(1, "BIgMac", "Testy");
            dr.setRestaurant(r);
            dishRecommendationRepository.save(dr);
            r.addDishRecomendations(dr);


            Restaurant r2 = new Restaurant(2, "Indian");
            DishRecommendation dr2 = new DishRecommendation(2, "Chiken", "Very Good");
            dr2.setRestaurant(r2);
            dishRecommendationRepository.save(dr2);
            r2.addDishRecomendations(dr2);

            DishRecommendation dr3 = new DishRecommendation(3, "Chikenburger", "Very Good");
            dr3.setRestaurant(r2);
            dishRecommendationRepository.save(dr3);
            r.addDishRecomendations(dr3);
            restaurantRepository.save(r);
            restaurantRepository.save(r2);

        };
    }


}
