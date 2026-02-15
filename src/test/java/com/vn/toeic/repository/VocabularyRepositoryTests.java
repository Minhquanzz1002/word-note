package com.vn.toeic.repository;

import com.vn.toeic.entity.Vocabulary;
import com.vn.toeic.mapper.IVocabularyMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VocabularyRepositoryTests {

    @Mock
    private IVocabularyMapper mapper;

    @InjectMocks
    private VocabularyRepository repository;

    @Test
    @DisplayName("save : normal : success")
    void testSaveSuccess() {
        when(mapper.save(any(Vocabulary.class))).thenReturn(1);

        Integer result = repository.save(mock(Vocabulary.class));
        assertNotNull(result);
    }

    @Test
    @DisplayName("update : normal : success")
    void testUpdateSuccess() {
        when(mapper.update(any(Vocabulary.class))).thenReturn(1);

        Integer result = repository.update(mock(Vocabulary.class));
        assertNotNull(result);
    }

    @Test
    @DisplayName("delete : normal : success")
    void testDeleteSuccess() {
        when(mapper.delete(any(Vocabulary.class))).thenReturn(1);

        Integer result = repository.delete(mock(Vocabulary.class));
        assertNotNull(result);
    }

    @Test
    @DisplayName("findById : normal : success")
    void testFindByIdSuccess() {
        when(mapper.findById(anyInt())).thenReturn(this.mockVocabularyList().getFirst());

        Vocabulary vocabulary = repository.findById(1);
        assertNotNull(vocabulary);
    }

    @Test
    @DisplayName("getAllByCreator : normal : success")
    void testGetAllByCreatorSuccess() {
        when(mapper.getAllByCreator(anyInt(), anyString(), anyInt(), anyInt())).thenReturn(this.mockVocabularyList());

        List<Vocabulary> vocabularies = repository.getAllByCreator(1, "h", 0, 10);
        assertNotNull(vocabularies);
        assertThat(vocabularies, Matchers.hasSize(Matchers.greaterThanOrEqualTo(1)));
    }

    @Test
    @DisplayName("existsVocabularyByCreatorAndWord : normal : success")
    void testExistsVocabularyByCreatorAndWordSuccess() {
        when(mapper.existsVocabularyByCreatorAndWord(anyInt(), anyString())).thenReturn(true);

        boolean result = repository.existsVocabularyByCreatorAndWord(1, "h");
        assertTrue(result);
    }

    /**
     * Mock the list of vocabulary.
     *
     * @return mocked the list of vocabulary.
     */
    private List<Vocabulary> mockVocabularyList() {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.setWordId(1);
        vocabulary.setWord("hello");

        return List.of(vocabulary);
    }
}
