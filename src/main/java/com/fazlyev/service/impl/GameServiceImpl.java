package com.fazlyev.service.impl;

import com.fazlyev.model.Games;
import com.fazlyev.repository.GameShopRepository;
import com.fazlyev.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    private final GameShopRepository gameShopRepository;

    @Autowired
    public GameServiceImpl(GameShopRepository gameShopRepository) {
        this.gameShopRepository = gameShopRepository;
    }

    @Override
    public Games saveGame(Games game) {
        return gameShopRepository.save(game);
    }
}
