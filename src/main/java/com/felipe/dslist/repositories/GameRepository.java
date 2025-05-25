package com.felipe.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.dslist.entitites.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
	
}
