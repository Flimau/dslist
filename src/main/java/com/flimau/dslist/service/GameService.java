package com.flimau.dslist.service;

import com.flimau.dslist.dto.GameMinDTO;
import com.flimau.dslist.entities.Game;
import com.flimau.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//registrar componentes para que o framework o gerencie, para isso a anotação service, ou pode usar a component
public class GameService{

    @Autowired// injeção do componente repository
    private GameRepository repository;

    public List<GameMinDTO> findAll(){
        List<Game> result = repository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }
}
