package com.flimau.dslist.service;

import com.flimau.dslist.dto.GameDTO;
import com.flimau.dslist.dto.GameMinDTO;
import com.flimau.dslist.entities.Game;
import com.flimau.dslist.repository.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//registrar componentes para que o framework o gerencie, para isso a anotação service, ou pode usar a component
@Service
public class GameService{

    @Autowired// injeção do componente repository
    private GameRepository repository;

    /*
    * A anotação @Transactional do Spring é usada para gerenciar transações de banco de dados.
    * Ela garante que todas as operações dentro de um método anotado sejam executadas em uma única transação.
    * Se algo der errado, as alterações no banco são revertidas (rollback).
    * Se tudo ocorrer bem, elas são confirmadas (commit).
    * A propriedade readOnly = true é usada para indicar que o método apenas lê dados do banco de dados
    *  e não realiza nenhuma alteração.
    */
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = repository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = repository.findById(id).get();
        return new GameDTO(result);
    }
}
