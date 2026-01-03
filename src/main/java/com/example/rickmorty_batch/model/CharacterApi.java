package com.example.rickmorty_batch.model;

import lombok.Data;

import java.util.List;

@Data
public class CharacterApi {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private Origin origin;
    private Location location;
    private List<String> episode;

    @Data
    public static class Origin {
        private String name;
    }

    @Data

    public static class Location {
        private String name;
    }

}
