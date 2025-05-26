package com.felipe.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.dslist.entitites.Game;
import com.felipe.dslist.entitites.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
	
}
