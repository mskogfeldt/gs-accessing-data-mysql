package starcheck.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import starcheck.business.DishRecommendation;

public interface DishRecommendationRepository extends JpaRepository<DishRecommendation,Long> {
}
