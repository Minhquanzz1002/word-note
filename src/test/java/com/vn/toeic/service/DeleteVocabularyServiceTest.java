package com.vn.toeic.service;

import com.vn.toeic.repository.VocabularyRepository;
import com.vn.toeic.request.DeleteVocabularyRequest;
import com.vn.toeic.response.DeleteVocabularyResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class DeleteVocabularyServiceTest {
    @Mock
    private VocabularyRepository vocabularyRepository;

    @InjectMocks
    private DeleteVocabularyService deleteVocabularyService;

    @Test
    @DisplayName("success")
    void deleteVocabularyServiceSuccess() {
        DeleteVocabularyRequest request = new DeleteVocabularyRequest();
        request.setWordId(1);

        DeleteVocabularyResponse response = deleteVocabularyService.mainFunc(request);

        assertNotNull(response);
    }
}
