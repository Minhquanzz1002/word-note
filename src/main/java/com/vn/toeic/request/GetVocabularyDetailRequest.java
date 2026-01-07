package com.vn.toeic.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Request an object for retrieving a vocabulary.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GetVocabularyDetailRequest extends BaseRequest {

    /**
     * The English vocabulary word ID.
     */
    @NotBlank
    private Integer wordId;

}
