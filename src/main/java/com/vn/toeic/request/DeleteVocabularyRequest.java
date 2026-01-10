package com.vn.toeic.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Request an object for deleting vocabulary.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeleteVocabularyRequest extends BaseRequest {

    /**
     * The English vocabulary word ID.
     */
    @NotNull
    private Integer wordId;

}
