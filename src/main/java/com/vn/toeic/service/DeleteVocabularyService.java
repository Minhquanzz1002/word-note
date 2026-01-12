package com.vn.toeic.service;

import com.vn.toeic.entity.Vocabulary;
import com.vn.toeic.repository.VocabularyRepository;
import com.vn.toeic.request.DeleteVocabularyRequest;
import com.vn.toeic.response.DeleteVocabularyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service class for creating the vocabulary.
 */
@Service
@RequiredArgsConstructor
public class DeleteVocabularyService extends BaseService<DeleteVocabularyRequest, DeleteVocabularyResponse> {

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
    protected DeleteVocabularyResponse mainFunc(DeleteVocabularyRequest request) {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.setWordId(request.getWordId());

        this.vocabularyRepository.delete(vocabulary);

        return new DeleteVocabularyResponse();
    }
}
