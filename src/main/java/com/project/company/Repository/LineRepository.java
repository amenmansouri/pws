package com.project.company.Repository;

import org.springframework.data.repository.CrudRepository;

import com.project.company.Entity.Line;

public interface LineRepository extends CrudRepository<Line,Integer>{

	Iterable<Line> findByAerodepNom(String nom);
	Iterable<Line> findByAerodepNomAndAeroarrNom(String nomdep,String nomarr);

	


}