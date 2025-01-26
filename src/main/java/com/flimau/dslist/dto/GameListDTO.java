package com.flimau.dslist.dto;

import com.flimau.dslist.entities.GameList;
import org.springframework.beans.BeanUtils;

public class GameListDTO {

    private long id;
    private String name;

    public GameListDTO() {
    }

    public GameListDTO(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
