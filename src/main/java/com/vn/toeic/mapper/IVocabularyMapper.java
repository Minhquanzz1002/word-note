package com.vn.toeic.mapper;

import com.vn.toeic.entity.Vocabulary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IVocabularyMapper extends BaseMapper<Vocabulary, Integer> {

    /**
     * Retrieves all vocabularies created by the specified creator.
     *
     * @param creator the creator ID.
     * @param keyword the keyword.
     * @param offset  the offset.
     * @param limit   the limit.
     * @return the list of vocabularies.
     */
    List<Vocabulary> getAllByCreator(Integer creator, String keyword, Integer offset, Integer limit);

    /**
     * Check whether vocabulary with the specified word already exists for the given creator.
     *
     * @param creator the creator ID.
     * @param word    the word.
     * @return true if the vocabulary exists, false otherwise
     */
    boolean existsVocabularyByCreatorAndWord(Integer creator, String word);
}
