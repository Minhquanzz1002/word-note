package com.vn.toeic.service;

import com.vn.toeic.entity.Vocabulary;
import com.vn.toeic.repository.VocabularyRepository;
import com.vn.toeic.request.GetVocabularyDetailRequest;
import com.vn.toeic.response.GetVocabularyDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetVocabularyDetailService extends BaseService<GetVocabularyDetailRequest, GetVocabularyDetailResponse> {

    private final VocabularyRepository vocabularyRepository;

    /**
     * Contains the main business logic of the service.
     *
     * @param request the request.
     * @return the response
     */
    @Override
    protected GetVocabularyDetailResponse mainFunc(GetVocabularyDetailRequest request) {
        Integer wordId = request.getWordId();
        Vocabulary vocabulary = vocabularyRepository.findById(wordId);

        GetVocabularyDetailResponse response = new GetVocabularyDetailResponse();
        response.addVocabulary(vocabulary);
        return response;
    }
}
