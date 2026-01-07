package com.vn.toeic.response;

import com.vn.toeic.common.Utilities;
import com.vn.toeic.entity.Vocabulary;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetVocabularyDetailResponse extends BaseResponse {

    private Map<String, Object> vocabulary;

    public void addVocabulary(Vocabulary voca) {
        Map<String, Object> vocabularyMap = new LinkedHashMap<>();
        vocabularyMap.put("wordId", voca.getWordId());
        vocabularyMap.put("word", voca.getWord());
        List<String> synonyms = Utilities.toStringList(voca.getSynonyms());
        vocabularyMap.put("meaning", voca.getMeaning());
        List<String> example = Utilities.toStringList(voca.getExample());
        vocabularyMap.put("synonyms", synonyms);
        vocabularyMap.put("example", example);

        this.vocabulary = vocabularyMap;
    }

}
