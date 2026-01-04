package com.vn.toeic.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entity representing a TOEIC vocabulary item.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Vocabulary extends BaseEntity {

    private Integer wordId;

    /**
     * The English vocabulary word.
     */
    private String word;

    /**
     * The Vietnamese meaning of the word.
     */
    private String meaning;

    /**
     * Synonyms of the word.
     */
    private String synonyms;

    /**
     * An example sentence demonstrating how the word is used.
     */
    private String example;
}
