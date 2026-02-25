package com.adrar.cdafad.repository;

import com.adrar.cdafad.entity.Category;
import com.adrar.cdafad.entity.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
    Optional<Game> findByTitle(String title);
}
