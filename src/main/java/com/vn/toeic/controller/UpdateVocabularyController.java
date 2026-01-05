package com.vn.toeic.controller;

import com.vn.toeic.common.Constant.ApiEndpoint;
import com.vn.toeic.request.CreateVocabularyRequest;
import com.vn.toeic.request.UpdateVocabularyRequest;
import com.vn.toeic.response.CreateVocabularyResponse;
import com.vn.toeic.response.UpdateVocabularyResponse;
import com.vn.toeic.service.UpdateVocabularyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for updating the vocabulary list.
 */
@RequestMapping
@RestController
@RequiredArgsConstructor
public class UpdateVocabularyController extends BaseController<UpdateVocabularyRequest, UpdateVocabularyResponse> {

    private final UpdateVocabularyService service;

    /**
     * Handles PUT requests for updating the vocabulary.
     *
     * @param request containing vocabulary data to update
     * @return a {@link ResponseEntity} containing {@link CreateVocabularyResponse} with
     * the result of the update operation
     */
    @PutMapping(ApiEndpoint.UPDATE_VOCABULARY)
    public ResponseEntity<UpdateVocabularyResponse> updateVocabulary(@Valid @RequestBody UpdateVocabularyRequest request) {
        UpdateVocabularyResponse response = new UpdateVocabularyResponse();
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
    ResponseEntity<UpdateVocabularyResponse> process(UpdateVocabularyRequest request, UpdateVocabularyResponse response) {
        UpdateVocabularyResponse resultResponse = this.service.execute(request);

        return this.buildNormalResponse(request, resultResponse);
    }
}
