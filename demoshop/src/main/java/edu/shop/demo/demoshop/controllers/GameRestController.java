package edu.shop.demo.demoshop.controllers;

import edu.shop.demo.demoshop.domain.Client;
import edu.shop.demo.demoshop.domain.Games;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameRestController {

    //Crud

    private final List<Games> games = new ArrayList<>(
            Arrays.asList(
                    new Games("Star Rail","123",50),
                    new Games("Lol","123", 22),
                    new Games("Rust", "222", 10)

            )
    );

    @GetMapping
    public List<Games> getAllGames()
    {
        return games;
    }

    @GetMapping("/{name}")
    public Games getGame(@PathVariable String name)
    {
        for (Games game : games)
        {
            if (game.getName().equalsIgnoreCase(name)){
                return game;
            }
        }

        return null;
    }

    @PostMapping
    public Games createGame(@RequestBody Games newGame)
    {
        games.add(newGame);
        return newGame;
    }

    @PutMapping
    public Games updateGame(@RequestBody Games nameGame)
    {
        for (Games game1 : games){
            if (game1.getName().equalsIgnoreCase(nameGame.getName())){
                game1.setName(nameGame.getName());
                game1.setDuration(nameGame.getDuration());
                game1.setPrice(nameGame.getPrice());

                return game1;
            }
        }

        return null;
    }

    @DeleteMapping("/{name}")
    public void deleteGame(@PathVariable String name)
    {
        for (Games game1 : games){
            if (game1.getName().equalsIgnoreCase(name)){
                games.remove(game1);
            }
        }
    }



}
