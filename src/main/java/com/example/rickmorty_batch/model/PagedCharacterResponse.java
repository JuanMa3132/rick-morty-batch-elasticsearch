package com.example.rickmorty_batch.model;


import lombok.Data;

import java.util.List;

@Data
public class PagedCharacterResponse {

    private ApiInfo info;
    private List<CharacterApi> results;
}
