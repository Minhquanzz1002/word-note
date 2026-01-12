package com.vn.toeic.controller;

import com.vn.toeic.common.Constant.ApiEndpoint;
import com.vn.toeic.request.DeleteVocabularyRequest;
import com.vn.toeic.response.DeleteVocabularyResponse;
import com.vn.toeic.service.DeleteVocabularyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for deleting the vocabulary.
 */
@RequestMapping
@RestController
@RequiredArgsConstructor
public class DeleteVocabularyController extends BaseController<DeleteVocabularyRequest, DeleteVocabularyResponse> {

    /**
     * Service used to process the vocabulary list retrieval logic.
     */
    private final DeleteVocabularyService service;

    /**
     * Handles DELETE requests for deleting the vocabulary.
     *
     * @param request the base request object containing request parameters
     *                (e.g. paging, search conditions)
     * @return a {@link ResponseEntity} containing {@link DeleteVocabularyResponse}
     * with the vocabulary data
     */
    @DeleteMapping(ApiEndpoint.DELETE_VOCABULARY)
    public ResponseEntity<DeleteVocabularyResponse> deleteVocabulary(@Valid @ModelAttribute DeleteVocabularyRequest request) {
        DeleteVocabularyResponse response = new DeleteVocabularyResponse();
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
    ResponseEntity<DeleteVocabularyResponse> process(DeleteVocabularyRequest request, DeleteVocabularyResponse response) {
        DeleteVocabularyResponse resultResponse = service.execute(request);
        return this.buildNormalResponse(request, resultResponse);
    }
}
