package starcheck.business;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private double starRating;


    @OneToMany(mappedBy = "restaurant")
    private List<DishRecommendation> dishRecommendations = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<DishRecommendation> starGradings = new ArrayList<>();

    public void addDishRecomendations(DishRecommendation recommendation){
        dishRecommendations.add(recommendation);
    }

    public List<DishRecommendation> getDishRecommendations() {
        return dishRecommendations;
    }

    public void setDishRecommendations(List<DishRecommendation> dishRecommendations) {
        this.dishRecommendations = dishRecommendations;
    }

    public Restaurant(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restaurant() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getStarRating() {
        return starRating;
    }

    public void setStarRating(double starRating) {
        this.starRating = starRating;
    }

   /*

    public void calculateStarRating(){
        starRating = totalRankingPoints/numberOfGradings;
    }

    */
}


