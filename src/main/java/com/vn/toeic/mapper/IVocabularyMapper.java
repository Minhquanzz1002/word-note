package com.vn.toeic.mapper;

import com.vn.toeic.entity.Vocabulary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IVocabularyMapper extends BaseMapper<Vocabulary, Integer> {
}
