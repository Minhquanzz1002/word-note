package com.vn.toeic.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Request an object for updating vocabulary.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateVocabularyRequest extends BaseRequest {

    /**
     * The English vocabulary word ID.
     */
    @NotNull
    private Integer wordId;

    /**
     * The English vocabulary word.
     */
    @NotBlank
    private String word;

    /**
     * The Vietnamese meaning of the word.
     */
    @NotBlank
    private String meaning;

    /**
     * Synonyms of the word.
     */
    private List<String> synonyms;

    /**
     * An example sentence demonstrating how the word is used.
     */
    private List<String> example;

}
