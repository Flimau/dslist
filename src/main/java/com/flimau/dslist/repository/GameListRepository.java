package com.flimau.dslist.repository;

import com.flimau.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
