package com.zhlzzz.tool.enums;

public enum LanguageEnum {

    AUTO("auto"), EN("en"), ZH("zh");

    private LanguageEnum(String code) {
        this.code = code;
    }

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
