package com.vn.toeic.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseResponse {
    private int statusCode;
    private int processResult;
    private List<Object> message = new ArrayList<>();
}
