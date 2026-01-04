package com.vn.toeic.controller;

import com.vn.toeic.common.Constant.ApiEndpoint;
import com.vn.toeic.request.GetVocabularyListRequest;
import com.vn.toeic.response.GetVocabularyListResponse;
import com.vn.toeic.service.GetVocabularyListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for retrieving the vocabulary list.
 */
@RequestMapping
@RestController
@RequiredArgsConstructor
public class GetVocabularyListController extends BaseController<GetVocabularyListRequest, GetVocabularyListResponse> {

    /**
     * Service used to process the vocabulary list retrieval logic.
     */
    private final GetVocabularyListService service;

    /**
     * Handles GET requests for retrieving the vocabulary list.
     *
     * @param request the base request object containing request parameters
     *                (e.g. paging, search conditions)
     * @return a {@link ResponseEntity} containing {@link GetVocabularyListResponse}
     * with the vocabulary list data
     */
    @GetMapping(ApiEndpoint.GET_VOCABULARY_LIST)
    public ResponseEntity<GetVocabularyListResponse> getVocabularyListResponseEntityResponse(
            @Valid @ModelAttribute GetVocabularyListRequest request) {
        GetVocabularyListResponse response = new GetVocabularyListResponse();
        return this.execute(request, response);
    }

    /**
     * Processes the business logic for retrieving the vocabulary list.
     *
     * @param request  the base request object from the client
     * @param response the response object to be populated
     * @return the populated {@link GetVocabularyListResponse}
     */
    @Override
    ResponseEntity<GetVocabularyListResponse> process(GetVocabularyListRequest request, GetVocabularyListResponse response) {
        GetVocabularyListResponse resultResponse = service.execute(request);
        return this.buildNormalResponse(request, resultResponse);
    }
}
