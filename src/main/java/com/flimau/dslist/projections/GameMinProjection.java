package com.flimau.dslist.projections;

public interface GameMinProjection {
    // aqui devera ter um metodo get() para cada
    // propriedade que a consulta retornar
    Long getId();
    String getTitle();
    int getGameYear();
    String getImgUrl();
    String getShortDescription();
    int getPosition();

}
