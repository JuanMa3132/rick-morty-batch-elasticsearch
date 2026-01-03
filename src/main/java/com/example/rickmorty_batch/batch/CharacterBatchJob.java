package com.example.rickmorty_batch.batch;

import com.example.rickmorty_batch.Service.RickMortyApiService;
import com.example.rickmorty_batch.elastic.CharacterDocument;
import com.example.rickmorty_batch.elastic.CharacterElasticRepository;
import com.example.rickmorty_batch.model.PagedCharacterResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class CharacterBatchJob {

    private final RickMortyApiService apiService;
    private final CharacterElasticRepository repository;

    public CharacterBatchJob(RickMortyApiService apiService,
                             CharacterElasticRepository repository) {
        this.apiService = apiService;
        this.repository = repository;

    }

    @PostConstruct
    public void run () {

        long existingDocs = repository.count();

        if (existingDocs > 0) {
            System.out.println("El indice ya tiene Datos (" + existingDocs + ") Batch NO ejecutado");
            return;
        }
        System.out.println("Indice Vacio. Ejecutandose Batch...");

        int page = 1;
        boolean hasNext = true;

        while (hasNext) {
            PagedCharacterResponse response =
                    apiService.getPage(page);

            response.getResults().forEach(api ->{
                CharacterDocument doc = new CharacterDocument();

                doc.setId(api.getId());
                doc.setName(api.getName());
                doc.setStatus(api.getStatus());
                doc.setSpecies(api.getSpecies());
                doc.setOrigin(api.getOrigin().getName());
                doc.setLastLocation(api.getLocation().getName());
                doc.setEpisodesCount(api.getEpisode().size());

                repository.save(doc);
            });

            hasNext = response.getInfo().getNext() != null;
            page++;

        }
        System.out.println("Batch COMPLETADO.");
    }

}
