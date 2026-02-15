package com.vn.toeic.common;

public class SystemValue {

    private SystemValue() {

    }

    public static class ProcessResult {
        private ProcessResult() {
        }

        public static final int API_RESPONSE_OK = 0;
        public static final int API_VALIDATE_NG = 1;

        /**
         * Error code indicating that the data already exists.
         */
        public static final int API_DATA_ALREADY_EXISTS = 2;

        /**
         * Error code indicating that the auth failed.
         */
        public static final int API_AUTH_FAILED = 3;
    }
}
