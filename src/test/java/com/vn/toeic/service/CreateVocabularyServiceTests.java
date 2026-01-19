package com.vn.toeic.service;

import com.vn.toeic.common.SystemValue.ProcessResult;
import com.vn.toeic.entity.Vocabulary;
import com.vn.toeic.repository.VocabularyRepository;
import com.vn.toeic.request.CreateVocabularyRequest;
import com.vn.toeic.response.CreateVocabularyResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@WebMvcTest(CreateVocabularyService.class)
class CreateVocabularyServiceTests {

    @MockitoBean
    private VocabularyRepository vocabularyRepository;

    @Autowired
    private CreateVocabularyService service;

    @Test
    @DisplayName("mainFunc : normal : save success")
    void testCreateVocabularySuccess() {
        CreateVocabularyRequest request = new CreateVocabularyRequest();
        request.setWord("hello");

        when(vocabularyRepository.existsVocabularyByCreatorAndWord(anyInt(), anyString())).thenReturn(false);
        when(vocabularyRepository.save(any(Vocabulary.class))).thenReturn(1);

        CreateVocabularyResponse response = service.mainFunc(request);
        assertThat(response.getProcessResult(), is(ProcessResult.API_RESPONSE_OK));
    }

    @Test
    @DisplayName("mainFunc : abnormal : word existed")
    void testWordExisted() {
        CreateVocabularyRequest request = new CreateVocabularyRequest();
        request.setWord("hello");

        when(vocabularyRepository.existsVocabularyByCreatorAndWord(anyInt(), anyString())).thenReturn(true);

        CreateVocabularyResponse response = service.mainFunc(request);
        assertThat(response.getProcessResult(), is(ProcessResult.API_DATA_ALREADY_EXISTS));
    }

}
