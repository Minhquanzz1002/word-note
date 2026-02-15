package com.vn.toeic.service;

import com.vn.toeic.common.Utilities;
import com.vn.toeic.entity.Vocabulary;
import com.vn.toeic.repository.VocabularyRepository;
import com.vn.toeic.request.GetVocabularyListRequest;
import com.vn.toeic.response.GetVocabularyListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Service class for retrieving the vocabulary list.
 */
@Service
@RequiredArgsConstructor
public class GetVocabularyListService extends BaseService<GetVocabularyListRequest, GetVocabularyListResponse> {

    /**
     * Repository used to access vocabulary data from the database.
     */
    private final VocabularyRepository vocabularyRepository;

    /**
     * Contains the main business logic of the service.
     *
     * @param request the request.
     * @return the response
     */
    @Override
    protected GetVocabularyListResponse mainFunc(GetVocabularyListRequest request) {
        Integer offset = Objects.nonNull(request.getOffset()) ? request.getOffset() : 0;
        Integer limit = Objects.nonNull(request.getLimit()) ? request.getLimit() : 20;
        String keyword = request.getKeyword();

        List<Vocabulary> vocabularies = this.vocabularyRepository.getAllByCreator(1, keyword, offset, limit);

        GetVocabularyListResponse response = new GetVocabularyListResponse();
        vocabularies.forEach(v -> {
            List<String> synonyms = Utilities.toStringList(v.getSynonyms());
            List<String> example = Utilities.toStringList(v.getExample());
            response.addVocabulary(v, synonyms, example);
        });

        return response;
    }

}
