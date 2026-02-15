package com.vn.toeic.common;

public class Constant {
    private Constant() {
    }

    public static class ApiEndpoint {
        private ApiEndpoint() {
        }

        public static final String CREATE_VOCABULARY = "/api/create-vocabulary";
        public static final String GET_VOCABULARY_LIST = "/api/get-vocabulary-list";
        public static final String GET_VOCABULARY_DETAIL = "/api/get-vocabulary-detail";
        public static final String UPDATE_VOCABULARY = "/api/update-vocabulary";
        public static final String DELETE_VOCABULARY = "/api/delete-vocabulary";

        public static final String LOGIN = "/api/login";
        public static final String REFRESH_TOKEN = "/api/refresh";
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

    public enum JwtType {
        ACCESS_TOKEN,
        REFRESH_TOKEN,
    }

    public static class UserStatus {
        private UserStatus() {
        }

        public static final String ACTIVE = "ACTIVE";
        public static final String INACTIVE = "INACTIVE";
    }

}
