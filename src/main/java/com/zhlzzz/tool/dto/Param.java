package com.zhlzzz.tool.dto;

import lombok.Data;

@Data
public class Param {

    private String q;

    private String from;

    private String to;

    private String appid;

    private String salt;

    private String sign;

}
