package com.flimau.dslist.controllers;

import com.flimau.dslist.dto.GameMinDTO;
import com.flimau.dslist.entities.Game;
import com.flimau.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    GameService service;

    @GetMapping
    public List<GameMinDTO> findAll(){
        return service.findAll();
    }
}
