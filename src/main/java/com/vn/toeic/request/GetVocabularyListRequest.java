package com.vn.toeic.request;

import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Request an object for retrieving a list of vocabularies.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GetVocabularyListRequest extends BaseRequest {
    /**
     * The starting index for pagination.
     */
    @Min(0)
    private Integer offset;

    /**
     * The maximum number of vocabulary records to return.
     */
    @Min(1)
    private Integer limit;

    /**
     * The keyword for search.
     */
    private String keyword;
}
