package com.fazlyev.controller;

import com.fazlyev.model.Games;
import com.fazlyev.model.User;
import com.fazlyev.service.GameService;
import com.fazlyev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
public class GameShopController {
    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public GameShopController(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @GetMapping("/shop")
    public String showHomePage() {
        return "shopPage";
    }

    @PostMapping("/shop/buy")
    public String buyGames(String[] select, Principal principal) {
        if (select != null && principal != null) {
            String username = principal.getName();
            User user = userService.findByUsername(username);

            List<String> selectedGameIds = Arrays.asList(select);
            for (String gameId : selectedGameIds) {
                Games game = new Games();
                game.setGameName(gameId);
                game.setUserId(user.getId());
                gameService.saveGame(game);
            }
            return "redirect:/homePage";
        }
        return "redirect:/shop";
    }
}
