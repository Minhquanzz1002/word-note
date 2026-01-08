package com.vn.toeic.controller;

import com.vn.toeic.common.Constant.ApiEndpoint;
import com.vn.toeic.request.GetVocabularyDetailRequest;
import com.vn.toeic.response.GetVocabularyDetailResponse;
import com.vn.toeic.service.GetVocabularyDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for retrieving the vocabulary.
 */
@RequestMapping
@RestController
@RequiredArgsConstructor
public class GetVocabularyDetailController extends BaseController<GetVocabularyDetailRequest, GetVocabularyDetailResponse> {

    /**
     * Service used to process the vocabulary list retrieval logic.
     */
    private final GetVocabularyDetailService service;

    /**
     * Handles GET requests for retrieving the vocabulary.
     *
     * @param request the base request object containing request parameters
     *                (e.g. paging, search conditions)
     * @return a {@link ResponseEntity} containing {@link GetVocabularyDetailResponse}
     * with the vocabulary data
     */
    @GetMapping(ApiEndpoint.GET_VOCABULARY_DETAIL)
    public ResponseEntity<GetVocabularyDetailResponse> getVocabularyDetail(@Valid @ModelAttribute GetVocabularyDetailRequest request) {
        GetVocabularyDetailResponse response = new GetVocabularyDetailResponse();
        return this.execute(request, response);
    }

    /**
     * Business processing.
     *
     * @param request  the request
     * @param response the response
     * @return {@link ResponseEntity} with success response
     */
    @Override
    ResponseEntity<GetVocabularyDetailResponse> process(GetVocabularyDetailRequest request, GetVocabularyDetailResponse response) {
        GetVocabularyDetailResponse resultResponse = service.execute(request);
        return this.buildNormalResponse(request, resultResponse);
    }
}
