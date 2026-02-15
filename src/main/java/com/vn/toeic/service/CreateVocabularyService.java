package com.vn.toeic.service;

import com.vn.toeic.common.SystemValue.ProcessResult;
import com.vn.toeic.common.Utilities;
import com.vn.toeic.entity.Vocabulary;
import com.vn.toeic.repository.VocabularyRepository;
import com.vn.toeic.request.CreateVocabularyRequest;
import com.vn.toeic.response.CreateVocabularyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        String word = request.getWord();
        boolean existWord = vocabularyRepository.existsVocabularyByCreatorAndWord(1, word);
        CreateVocabularyResponse response = new CreateVocabularyResponse();
        if (existWord) {
            response.setProcessResult(ProcessResult.API_DATA_ALREADY_EXISTS);
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            return response;
        }

        Vocabulary vocabulary = new Vocabulary();
        vocabulary.setWord(word);
        vocabulary.setMeaning(request.getMeaning());
        vocabulary.setSynonyms(Utilities.listToJson(request.getSynonyms()));
        vocabulary.setExample(Utilities.listToJson(request.getExample()));

        this.vocabularyRepository.save(vocabulary);

        return response;
    }
}
