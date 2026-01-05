package com.vn.toeic.common;

public class Constant {
    private Constant() {
    }

    public static class ApiEndpoint {
        private ApiEndpoint() {
        }

        public static final String GET_VOCABULARY_LIST = "/api/get-vocabulary-list";
        public static final String CREATE_VOCABULARY = "/api/create-vocabulary";
        public static final String UPDATE_VOCABULARY = "/api/update-vocabulary";
    }

    public static class DelFlg {
        private DelFlg() {
        }

        public static final byte DELETED = 1;
        public static final byte NOT_DELETED = 0;
    }

    public static class VersionNo {
        private VersionNo() {
        }

        public static final int INIT = 0;
    }

    public static class Number {
        private Number() {
        }

        public static final int ONE = 1;
    }

    public enum AuditAction {
        CREATE,
        UPDATE,
        DELETE;
    }

}
