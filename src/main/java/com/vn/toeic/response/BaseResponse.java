package com.vn.toeic.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseResponse {
    private Integer statusCode;
    private Integer processResult;
    private List<Object> message = new ArrayList<>();
}
