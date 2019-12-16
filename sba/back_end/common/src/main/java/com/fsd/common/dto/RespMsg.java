package com.fsd.common.dto;

import lombok.Data;

@Data
public class RespMsg {

    private boolean status;
    private String code;
    private String msg;
    private String error;
    private Object data;

}
