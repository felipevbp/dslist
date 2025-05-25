package com.felipe.dslist.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipe.dslist.dto.GameDTO;
import com.felipe.dslist.dto.GameMinDTO;
import com.felipe.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;

	public List<GameMinDTO> findAll() {
		var result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}

	@Transactional(readOnly = true) //Garante a operação no banco de dados vai acontecer
	public GameDTO findById(Long gameId) {
		var result = gameRepository.findById(gameId).get();
		//TODO Tratamento de exceção para o caso não haver o objeto
		return new GameDTO(result);
	}
	
	
	
}
