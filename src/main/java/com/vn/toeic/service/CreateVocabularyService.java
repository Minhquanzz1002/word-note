package com.vn.toeic.service;

import com.vn.toeic.common.Utilities;
import com.vn.toeic.entity.Vocabulary;
import com.vn.toeic.repository.VocabularyRepository;
import com.vn.toeic.request.CreateVocabularyRequest;
import com.vn.toeic.response.CreateVocabularyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service class for creating the vocabulary.
 */
@Service
@RequiredArgsConstructor
public class CreateVocabularyService extends BaseService<CreateVocabularyRequest, CreateVocabularyResponse> {

    /**
     * Repository for interacting with the database table for Vocabulary entities.
     */
    private final VocabularyRepository vocabularyRepository;

    /**
     * Contains the main business logic of the service.
     *
     * @param request the request.
     * @return the response
     */
    @Override
    protected CreateVocabularyResponse mainFunc(CreateVocabularyRequest request) {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.setWord(request.getWord());
        vocabulary.setMeaning(request.getMeaning());
        vocabulary.setSynonyms(Utilities.listToJson(request.getSynonyms()));
        vocabulary.setExample(Utilities.listToJson(request.getExample()));

        this.vocabularyRepository.save(vocabulary);

        return new CreateVocabularyResponse();
    }
}
