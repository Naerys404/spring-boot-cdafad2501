package com.adrar.cdafad.service;

import com.adrar.cdafad.entity.Game;
import com.adrar.cdafad.entity.Manufacturer;
import com.adrar.cdafad.exception.manufacturer.ManufacturerIsNotExistsException;
import com.adrar.cdafad.exception.manufacturer.ManufacturerListIsEmptyException;
import com.adrar.cdafad.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    //Méthode pour récupérer un game
    public Game getGameById(Integer id) throws Exception
    {
        Optional<Game> game = gameRepository.findById(id);
        //Test si il n'existe pas
        if (game.isEmpty()) {
            throw new Exception("Le jeu n'existe pas.");
        }
        return game.get();
    }

    //Méthode pour récupérer la liste des games
    public Iterable<Game> getAllGames() throws Exception
    {
        //Test si la liste est vide
        if (this.gameRepository.count() == 0) {
            throw new Exception("La liste de jeux est vide");
        }
        return gameRepository.findAll();
    }

}
