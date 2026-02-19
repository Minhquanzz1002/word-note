package com.vn.toeic.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Request an object for creating vocabulary.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CreateVocabularyRequest extends BaseRequest {

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
     * The type of the word.
     */
    @Pattern(regexp = "^(Noun|Verb|Adjective|Adverb|Preposition|Conjunction|Interjection)?$")
    private String wordType;

    /**
     * Synonyms of the word.
     */
    private List<String> synonyms;

    /**
     * An example sentence demonstrating how the word is used.
     */
    private List<String> example;
}
