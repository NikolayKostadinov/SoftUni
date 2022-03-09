package com.manhattan.services.interfaces;

import com.manhattan.models.dtos.GameAddDto;

public interface GameService {
    String add(GameAddDto gameAddDto);

    String editGame(int id, String... values);

    String deleteGame(int id);

    String getAll();

    String getGameDetails(String title);
}
