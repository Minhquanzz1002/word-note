package com.vn.toeic.controller;

import com.vn.toeic.common.Constant;
import com.vn.toeic.common.SystemValue.ProcessResult;
import com.vn.toeic.request.BaseRequest;
import com.vn.toeic.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

/**
 * Base controller that defines a common execution flow for all APIs.
 *
 * @param <T> request type, must extend {@link BaseRequest}
 * @param <D> response type, must extend {@link BaseResponse}
 */
public abstract class BaseController<T extends BaseRequest, D extends BaseResponse> {
    /**
     * Executes the service flow: validate input and process business logic.
     *
     * @param request  the request
     * @param response the response
     * @return {@link ResponseEntity} containing the response
     */
    public final ResponseEntity<D> execute(T request, D response) {
        int validateResult = this.validate(request, response);
        if (!Objects.equals(ProcessResult.API_RESPONSE_OK, validateResult)) {
            return this.buildValidateResponse(request, response);
        }
        D resultResponse = process(request, response);
        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
    }

    /**
     * Validate request data.
     *
     * @param request  the request
     * @param response the response
     * @return the validate code
     */
    protected int validate(T request, D response) {
        return Constant.ProcessResult.API_RESPONSE_OK;
    }

    /**
     * Business processing.
     *
     * @param request  the request
     * @param response the response
     * @return {@link ResponseEntity} with success response
     */
    abstract D process(T request, D response);

    /**
     * Build error response (common).
     *
     * @param request  the request
     * @param response the response
     * @return {@link ResponseEntity} with error response
     */
    protected ResponseEntity<D> buildValidateResponse(T request, D response) {
        response.setProcessResult(ProcessResult.API_VALIDATE_NG);
        response.setStatusCode(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
