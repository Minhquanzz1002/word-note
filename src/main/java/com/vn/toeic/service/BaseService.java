package com.vn.toeic.service;

import com.vn.toeic.request.BaseRequest;
import com.vn.toeic.response.BaseResponse;

/**
 * Base service class that defines a common execution flow for all services.
 *
 * @param <T> request type
 * @param <D> response type
 */
public abstract class BaseService<T extends BaseRequest, D extends BaseResponse> {

    /**
     * Executes the service flow: validate input and process business logic.
     *
     * @param request the request
     * @return the response
     */
    public final D execute(T request) {
        this.validate(request);
        return mainFunc(request);
    }

    /**
     * Validate the request. Throw an exception if validation fails.
     *
     * @param request the request
     */
    protected void validate(T request) {
        // default: do nothing
    }

    /**
     * Contains the main business logic of the service.
     *
     * @param request the request.
     * @return the response
     */
    protected abstract D mainFunc(T request);
}
