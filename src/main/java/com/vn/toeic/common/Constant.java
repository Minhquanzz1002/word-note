package com.vn.toeic.common;

import lombok.Data;

public class Constant {
    private Constant() {
    }

    public static class ApiEndpoint {
        private ApiEndpoint() {
        }

        public static final String GET_VOCABULARY_LIST = "/api/get-vocabulary-list";
    }

    public static class ProcessResult {
        private ProcessResult() {
        }

        public static final int API_RESPONSE_OK = 0;
        public static final int API_VALIDATE_NG = 1;
    }

    public static class DelFlg {
        private DelFlg() {
        }

        public static final byte DELETED = 1;
        public static final byte NOT_DELETED = 0;
    }

    @Data
    public static class VersionNo {
        private VersionNo() {
        }

        public static final int INIT = 0;
    }

    public enum AuditAction {
        CREATE,
        UPDATE,
        DELETE;
    }

}
