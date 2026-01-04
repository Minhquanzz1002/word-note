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
     * @return the list of vocabularies.
     */
    List<Vocabulary> getAllByCreator(Integer creator);

}
