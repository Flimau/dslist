package com.flimau.dslist.service;


import com.flimau.dslist.dto.GameListDTO;
import com.flimau.dslist.entities.GameList;
import com.flimau.dslist.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired// injeção do componente repository
    private GameListRepository repository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = repository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

}
