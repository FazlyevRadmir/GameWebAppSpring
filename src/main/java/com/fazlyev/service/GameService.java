package com.fazlyev.service;

import com.fazlyev.model.Games;
import com.fazlyev.repository.GameShopRepository;
import org.springframework.stereotype.Service;

@Service
public interface GameService {
    Games saveGame(Games game);
}
