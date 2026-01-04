package com.vn.toeic.repository;

import com.vn.toeic.common.Constant.AuditAction;
import com.vn.toeic.entity.Vocabulary;
import com.vn.toeic.mapper.IVocabularyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VocabularyRepository extends BaseRepository<Vocabulary, Integer> {

    private final IVocabularyMapper vocabularyMapper;

    /**
     * Inserts a new entity into the database.
     *
     * @param entity the entity to save
     * @return the number of rows affected
     */
    @Override
    public int save(Vocabulary entity) {
        this.setAuditFields(entity, AuditAction.CREATE);
        return vocabularyMapper.save(entity);
    }

    @Override
    public int update(Vocabulary entity) {
        this.setAuditFields(entity, AuditAction.UPDATE);
        return vocabularyMapper.update(entity);
    }

    @Override
    public int delete(Vocabulary entity) {
        this.setAuditFields(new Vocabulary(), AuditAction.DELETE);
        return vocabularyMapper.delete(entity);
    }

    @Override
    public Vocabulary findById(Integer id) {
        return vocabularyMapper.findById(id);
    }

    /**
     * Retrieves all vocabularies created by the specified creator.
     *
     * @param creator the creator ID.
     * @param offset  the offset.
     * @param limit   the limit.
     * @return the list of vocabularies.
     */
    public List<Vocabulary> getAllByCreator(Integer creator, Integer offset, Integer limit) {
        return vocabularyMapper.getAllByCreator(creator, offset, limit);
    }
}
