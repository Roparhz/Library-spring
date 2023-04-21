package fr.julienleveque.cefimtestcda2.entities.repository;

import fr.julienleveque.cefimtestcda2.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
