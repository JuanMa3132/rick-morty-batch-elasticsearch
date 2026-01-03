//package com.example.rickmorty_batch.test;
//
//import com.example.rickmorty_batch.elastic.CharacterDocument;
//import com.example.rickmorty_batch.elastic.CharacterElasticRepository;
//import jakarta.annotation.PostConstruct;
//import org.springframework.stereotype.Component;
//
//@Component
////// public class ElasticSmokeTest {
////
////    private final CharacterElasticRepository repository;
////
////    public ElasticSmokeTest(CharacterElasticRepository repository) {
////        this.repository = repository;
////    }
////    @PostConstruct
////
////    public void testElastic() {
////
////        CharacterDocument doc = new CharacterDocument();
////        doc.setId(999);
////        doc.setName("Test Character");
////        doc.setStatus("Alive");
////        doc.setSpecies("Human");
////        doc.setOrigin("Test Origin");
////        doc.setLastLocation("Test Location");
////        doc.setEpisodesCount(1);
////
////        repository.save(doc);
////
////        System.out.println("Documento de prueba guardado en Elastic");
//
//    }
//}
