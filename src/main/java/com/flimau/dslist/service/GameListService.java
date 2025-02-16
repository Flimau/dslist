package com.flimau.dslist.service;


import com.flimau.dslist.dto.GameListDTO;
import com.flimau.dslist.dto.GameMinDTO;
import com.flimau.dslist.entities.GameList;
import com.flimau.dslist.projections.GameMinProjection;
import com.flimau.dslist.repository.GameListRepository;
import com.flimau.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired// injeção do componente repository
    private GameListRepository repository;

    @Autowired// injeção do componente repository
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = repository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex,obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <= max; i++){
            repository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
