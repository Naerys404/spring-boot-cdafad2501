package com.adrar.cdafad.service;

import com.adrar.cdafad.entity.Category;
import com.adrar.cdafad.entity.Game;
import com.adrar.cdafad.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameService {
    private GameRepository gameRepository;

    //Méthodes du service
    //Méthode qui ajoute un game
    public Game createGame(Game game) throws Exception {

        if(gameRepository.findByTitle(game.getTitle()).isPresent()) {
            throw new Exception(game.getTitle() + " existe déjà.");
        }

        return gameRepository.save(game);
    }

}
