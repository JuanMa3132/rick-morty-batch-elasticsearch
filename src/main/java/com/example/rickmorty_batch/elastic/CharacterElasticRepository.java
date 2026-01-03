package com.example.rickmorty_batch.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CharacterElasticRepository
    extends ElasticsearchRepository<CharacterDocument, Integer> {
    }
