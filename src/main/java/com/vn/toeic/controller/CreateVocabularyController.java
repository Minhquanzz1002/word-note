package com.vn.toeic.controller;

import com.vn.toeic.common.Constant.ApiEndpoint;
import com.vn.toeic.request.CreateVocabularyRequest;
import com.vn.toeic.response.CreateVocabularyResponse;
import com.vn.toeic.service.CreateVocabularyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for creating the vocabulary.
 */
@RequestMapping
@RestController
@RequiredArgsConstructor
public class CreateVocabularyController extends BaseController<CreateVocabularyRequest, CreateVocabularyResponse> {

    private final CreateVocabularyService service;

    /**
     * Handles POST requests for creating the vocabulary.
     *
     * @param request containing vocabulary data to create
     * @return a {@link ResponseEntity} containing {@link CreateVocabularyResponse} with
     * the result of the create operation
     */
    @PostMapping(ApiEndpoint.CREATE_VOCABULARY)
    public ResponseEntity<CreateVocabularyResponse> createVocabulary(@Valid @RequestBody CreateVocabularyRequest request) {
        CreateVocabularyResponse response = new CreateVocabularyResponse();
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
    ResponseEntity<CreateVocabularyResponse> process(CreateVocabularyRequest request, CreateVocabularyResponse response) {
        CreateVocabularyResponse resultResponse = this.service.execute(request);
        return this.buildNormalResponse(request, resultResponse);
    }
}
