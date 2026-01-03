package com.example.rickmorty_batch.elastic;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "characters")
public class CharacterDocument {

    @Id
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String origin;
    private String lastLocation;
    private int episodesCount;
}
