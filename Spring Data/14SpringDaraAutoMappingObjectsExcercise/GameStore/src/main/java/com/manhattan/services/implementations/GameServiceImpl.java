package com.manhattan.services.implementations;

import com.manhattan.models.dtos.GameAddDto;
import com.manhattan.models.entities.Game;
import com.manhattan.repositories.GameRepository;
import com.manhattan.services.interfaces.GameService;
import com.manhattan.utils.ValidationsUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository repository;
    private final ModelMapper modelMapper;
    private final ValidationsUtil validator;


    public GameServiceImpl(GameRepository repository, ModelMapper modelMapper, ValidationsUtil validator) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public String add(GameAddDto model) {
        this.validator.validateModel(model);
        Game game = this.modelMapper.map(model, Game.class);
        this.repository.saveAndFlush(game);
        return String.format("Added %s", game.getTitle());
    }
}
