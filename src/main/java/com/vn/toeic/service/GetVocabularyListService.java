package com.vn.toeic.service;

import com.vn.toeic.common.Utilities;
import com.vn.toeic.entity.Vocabulary;
import com.vn.toeic.repository.VocabularyRepository;
import com.vn.toeic.request.BaseRequest;
import com.vn.toeic.response.GetVocabularyListResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Service class for retrieving the vocabulary list.
 */
@RequiredArgsConstructor
public class GetVocabularyListService extends BaseService<BaseRequest, GetVocabularyListResponse> {

    /**
     * Repository used to access vocabulary data from the database.
     */
    private final VocabularyRepository vocabularyRepository;

    /**
     * Main business logic for retrieving the vocabulary list.
     *
     * @param request the base request object containing input conditions
     *                such as paging or search criteria
     * @return a {@link GetVocabularyListResponse} containing the vocabulary list
     */
    @Override
    protected GetVocabularyListResponse mainFunc(BaseRequest request) {
        List<Vocabulary> vocabularies = this.vocabularyRepository.getAllByCreator(1);

        GetVocabularyListResponse response = new GetVocabularyListResponse();
        vocabularies.forEach(v -> {
            List<String> synonyms = Utilities.toStringList(v.getSynonyms());
            List<String> example = Utilities.toStringList(v.getExample());
            response.addVocabulary(v, synonyms, example);
        });

        return response;
    }

}
