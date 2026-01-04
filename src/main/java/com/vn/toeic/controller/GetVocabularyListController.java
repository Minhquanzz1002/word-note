package com.vn.toeic.controller;

import com.vn.toeic.request.BaseRequest;
import com.vn.toeic.response.BaseResponse;
import com.vn.toeic.response.GetVocabularyListResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class GetVocabularyListController extends BaseController<BaseRequest, GetVocabularyListResponse> {

    @GetMapping("/api/get-vocabulary-list")
    public ResponseEntity<GetVocabularyListResponse> getVocabularyListResponseEntityResponse(@ModelAttribute BaseRequest request) {
        GetVocabularyListResponse response = new GetVocabularyListResponse();
        return this.execute(request, response);
    }

    @Override
    ResponseEntity<GetVocabularyListResponse> process(BaseRequest request, GetVocabularyListResponse response) {
        return null;
    }
}
