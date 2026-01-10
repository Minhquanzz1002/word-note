package com.vn.toeic.response;

import com.vn.toeic.entity.Vocabulary;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Response object for getting a vocabulary list.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GetVocabularyListResponse extends BaseResponse {

    /**
     * Vocabulary list data.
     */
    private List<Map<String, Object>> vocabularies = new ArrayList<>();

    /**
     * Add vocabulary entity data to response.
     *
     * @param vocabulary entity fetched from the database
     * @param synonyms   list of synonym words
     * @param example    list of example sentences
     */
    public void addVocabulary(Vocabulary vocabulary, List<String> synonyms, List<String> example) {
        Map<String, Object> vocabularyMap = new LinkedHashMap<>();
        vocabularyMap.put("wordId", vocabulary.getWordId());
        vocabularyMap.put("word", vocabulary.getWord());
        vocabularyMap.put("meaning", vocabulary.getMeaning());
        vocabularyMap.put("synonyms", synonyms);
        vocabularyMap.put("example", example);

        this.vocabularies.add(vocabularyMap);
    }
}
