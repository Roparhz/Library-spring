package fr.julienleveque.cefimtestcda2.entities.repository;

import fr.julienleveque.cefimtestcda2.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
