package com.vn.toeic.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class SystemValueTests {

    @Test
    @DisplayName("Verify ProcessResult constant values")
    void testProcessResultConstants() {
        assertThat(SystemValue.ProcessResult.API_RESPONSE_OK, is(0));
        assertThat(SystemValue.ProcessResult.API_VALIDATE_NG, is(1));
        assertThat(SystemValue.ProcessResult.API_DATA_ALREADY_EXISTS, is(2));
    }

}
