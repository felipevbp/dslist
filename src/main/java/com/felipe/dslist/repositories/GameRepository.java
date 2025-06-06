package com.felipe.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.felipe.dslist.entitites.Game;
import com.felipe.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long>{

	public static final String STRING_CONSULTA_LISTA_POR_ID = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.game_list_id = :listId
			ORDER BY tb_belonging.position
				""";

	@Query(nativeQuery = true, value = STRING_CONSULTA_LISTA_POR_ID)
	List<GameMinProjection> searchByList(Long listId);
}
