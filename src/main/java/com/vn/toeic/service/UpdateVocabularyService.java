package com.vn.toeic.service;

import com.vn.toeic.common.Utilities;
import com.vn.toeic.entity.Vocabulary;
import com.vn.toeic.repository.VocabularyRepository;
import com.vn.toeic.request.UpdateVocabularyRequest;
import com.vn.toeic.response.UpdateVocabularyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for updating the vocabulary.
 */
@Service
@RequiredArgsConstructor
public class UpdateVocabularyService extends BaseService<UpdateVocabularyRequest, UpdateVocabularyResponse> {

    private final VocabularyRepository vocabularyRepository;

    /**
     * Contains the main business logic of the service.
     *
     * @param request the request.
     * @return the response
     */
    @Override
    @Transactional
    protected UpdateVocabularyResponse mainFunc(UpdateVocabularyRequest request) {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.setWordId(request.getWordId());
        vocabulary.setWord(request.getWord());
        vocabulary.setSynonyms(Utilities.listToJson(request.getSynonyms()));
        vocabulary.setExample(Utilities.listToJson(request.getExample()));

        this.vocabularyRepository.update(vocabulary);
        return new UpdateVocabularyResponse();
    }
}
