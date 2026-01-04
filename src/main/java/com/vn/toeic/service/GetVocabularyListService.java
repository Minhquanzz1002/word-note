package com.vn.toeic.service;

import com.vn.toeic.repository.VocabularyRepository;
import com.vn.toeic.request.BaseRequest;
import com.vn.toeic.response.BaseResponse;
import com.vn.toeic.response.GetVocabularyListResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetVocabularyListService extends BaseService<BaseRequest, GetVocabularyListResponse> {

    private final VocabularyRepository vocabularyRepository;

    @Override
    protected BaseRequest mainFunc(GetVocabularyListResponse request) {

        return null;
    }

}
