package com.example.rickmorty_batch.controller;

import com.example.rickmorty_batch.elastic.CharacterDocument;
import com.example.rickmorty_batch.elastic.CharacterElasticRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterQueryController {

    private final CharacterElasticRepository repository;

    public CharacterQueryController(CharacterElasticRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<CharacterDocument> getAll() {

        List<CharacterDocument> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }
}
