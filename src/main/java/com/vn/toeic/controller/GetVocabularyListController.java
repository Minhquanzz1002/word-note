package com.vn.toeic.controller;

import com.vn.toeic.request.BaseRequest;
import com.vn.toeic.response.GetVocabularyListResponse;
import com.vn.toeic.service.GetVocabularyListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for retrieving the vocabulary list.
 */
@RequestMapping
@RequiredArgsConstructor
public class GetVocabularyListController extends BaseController<BaseRequest, GetVocabularyListResponse> {

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
    @GetMapping("/api/get-vocabulary-list")
    public ResponseEntity<GetVocabularyListResponse> getVocabularyListResponseEntityResponse(
            @ModelAttribute BaseRequest request) {
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
    GetVocabularyListResponse process(BaseRequest request, GetVocabularyListResponse response) {
        return service.execute(request);
    }
}
