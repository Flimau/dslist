package com.flimau.dslist.controllers;

import com.flimau.dslist.dto.GameDTO;
import com.flimau.dslist.dto.GameListDTO;
import com.flimau.dslist.dto.GameMinDTO;
import com.flimau.dslist.service.GameListService;
import com.flimau.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService service;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}/games")
    public List<GameMinDTO> findByList(@PathVariable long id){
        return gameService.findByList(id);
    }

}
