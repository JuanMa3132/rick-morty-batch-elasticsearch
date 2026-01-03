package com.example.rickmorty_batch.Service;


import com.example.rickmorty_batch.model.PagedCharacterResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RickMortyApiService {
    private static final String BASE_URL =
            "https://rickandmortyapi.com/api/character";

    private final RestTemplate restTemplate = new RestTemplate();

    public PagedCharacterResponse getPage(int page) {
        String url = BASE_URL + "?page=" + page;
        return restTemplate.getForObject(url, PagedCharacterResponse.class);
    }
}
