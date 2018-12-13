package com.project.company.Repository;
import org.springframework.data.repository.CrudRepository;

import com.project.company.Entity.Reservation;;

public interface ReservationRepository extends CrudRepository<Reservation,Integer>{

	
}
