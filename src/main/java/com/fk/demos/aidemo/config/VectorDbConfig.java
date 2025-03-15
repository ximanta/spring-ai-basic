//package com.fk.demos.aidemo.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.ai.document.Document;
//import org.springframework.ai.embedding.EmbeddingModel;
//import org.springframework.ai.reader.tika.TikaDocumentReader;
//import org.springframework.ai.transformer.splitter.TextSplitter;
//import org.springframework.ai.transformer.splitter.TokenTextSplitter;
//import org.springframework.ai.vectorstore.SimpleVectorStore;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.File;
//import java.util.List;
//
//@Configuration
//@Slf4j
//public class VectorDbConfig {
//    @Bean
//    public SimpleVectorStore simpleVectorStore(EmbeddingModel embeddingModel, VectorDbProperties vectorStoreProperties) {
//        SimpleVectorStore store = SimpleVectorStore.builder(embeddingModel).build();
//
//        File vectorStoreFile = new File(vectorStoreProperties.getVectorStorePath());
//
//        if (vectorStoreFile.exists()) {
//            store.load(vectorStoreFile);
//        } else {
//            log.debug("Loading documents into vector store");
//            vectorStoreProperties.getDocumentsToLoad().forEach(document -> {
//                log.debug("Loading document: " + document.getFilename());
//                TikaDocumentReader documentReader = new TikaDocumentReader(document);
//                List<Document> docs = documentReader.get();
//                TextSplitter textSplitter = new TokenTextSplitter();
//                List<Document> splitDocs = textSplitter.apply(docs);
//                store.add(splitDocs);
//            });
//
//            store.save(vectorStoreFile);
//        }
//
//        return store;
//    }
//}
