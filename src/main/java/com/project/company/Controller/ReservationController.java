package com.project.company.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.company.Entity.Reservation;
import com.project.company.Entity.Voyager;
import com.project.company.Entity.Vol;
import com.project.company.Repository.ReservationRepository;
import com.project.company.Repository.VolRepository;
import com.project.company.Repository.VoyagerRepository;
@RestController
@RequestMapping("reservation")
public class ReservationController {
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	VolRepository volRepository;
	@Autowired
	VoyagerRepository voyagerRepository;
	@PostMapping("add/{classe}/{vo}/{voy}")
	@ResponseBody ResponseEntity<?> addReservation(@PathVariable Integer vo,@PathVariable Integer voy,@PathVariable String classe){
					
					Vol vol;
					vol=(Vol)volRepository.findOne(vo);
					System.out.println(vol);
					Voyager voyager=voyagerRepository.findOne(voy);
					System.out.println(voyager);
					if(vol!=null && voyager!=null) {
						if(classe.equals("economic") && vol.getEconomicPlaceNumber()>0) {
							Reservation r=new Reservation();
							vol.setEconomicPlaceNumber(vol.getEconomicPlaceNumber()-1);
							volRepository.save(vol);
							r.setVol(vol);
							r.setVoyager(voyager);
							reservationRepository.save(r);
							return new ResponseEntity<Reservation>(r,HttpStatus.CREATED);
						}
						 if(classe.equals("busness") && vol.getBusnessPlaceNumber()>0) {
							 Reservation r=new Reservation();
							vol.setEconomicPlaceNumber(vol.getBusnessPlaceNumber()-1);
							volRepository.save(vol);
							r.setVol(vol);
							r.setVoyager(voyager);
							reservationRepository.save(r);
							return new ResponseEntity<Reservation>(r,HttpStatus.CREATED);
						}}
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
