package com.adrar.cdafad.controller;


import com.adrar.cdafad.entity.Game;
import org.springframework.http.ResponseEntity;
import com.adrar.cdafad.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class GameController {

    private GameService gameService;

    @PostMapping("/game")
    public ResponseEntity<Game> addGame(@RequestBody Game game) throws Exception {
        Game newGame = this.gameService.createGame(game);
        return new ResponseEntity<>(newGame, HttpStatus.CREATED);
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Integer id) throws Exception {
        Game game = this.gameService.getGameById(id);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @GetMapping("/games")
    public ResponseEntity<Iterable<Game>> getAllGames() throws Exception
    {
        Iterable<Game> games = this.gameService.getAllGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

}
